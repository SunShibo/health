package com.example.service;

import com.example.api.CommonService;
import com.example.dao.PhysicalDAO;
import com.example.domain.*;
import com.example.service.util.XmlUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysicalService {

    @Autowired
    PhysicalDAO physicalDAO;

    //根据患者索引查询历次体检记录，bug：不确定患者索引类型
    public List<Physical> getList(String SourceSystem, String MessageID, String PATPatientID) {
        // 数据准备
        String xmlStr = "<Request>\n" +
                "    <Header>\n" +
                "        <SourceSystem>" + SourceSystem + "</SourceSystem>\n" +
                "        <MessageID>" + MessageID + "</MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <MedExamRt>\n" +
                "            <PATPatientID>" + PATPatientID + "</PATPatientID>\n" +
                "        </MedExamRt>\n" +
                "    </Body>\n" +
                "</Request>\n";
        //远程调用，获取到xml数据
        String result=this.sendWebService(xmlStr,"BOE0074");
        //转成对象
        Response r= XmlUtils.xmlToObject(Response.class,result);
        //插入数据库
        physicalDAO.delPhysical(new Long(PATPatientID));
        List<Physical> physicalList=r.getBody().getMedExamRp().getPhysicalsList();
        for (Physical physical:physicalList) {
            physical.setSourceSystem(SourceSystem);
            physical.setMessageID(MessageID);
            physical.setPatId(new Long(PATPatientID));
        }

        physicalDAO.addPhysical(physicalList);
        //返回数据
        return r.getBody().getMedExamRp().getPhysicalsList();
    }

    //根据体检记录查询建议bug：不确定一条体检记录对应几条建议,目前按文档的多条做的
    public List<Suggest> getSuggest(String SourceSystem, String MessageID, Long MedExamID){
        // 数据准备
        String xmlStr = "<Request>\n" +
                "    <Header>\n" +
                "        <SourceSystem>"+SourceSystem+"</SourceSystem>\n" +
                "        <MessageID>"+MessageID+"</MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <MedExamSummaryRt>\n" +
                "            <MedExamID>"+MessageID+"</MedExamID>\n" +
                "        </MedExamSummaryRt>\n" +
                "    </Body>\n" +
                "</Request>\n";
        //远程调用，获取到xml数据
        String result=this.sendWebService(xmlStr,"BOE0075");
        //转成对象
        Response r= XmlUtils.xmlToObject(Response.class,result);
        //插入数据库
        physicalDAO.delSuggests(MedExamID);
        List<Suggest> suggests=r.getBody().getMedExamSummaryRp().getSuggestList();
        for (Suggest suggest:suggests) {
            suggest.setSourceSystem(SourceSystem);
            suggest.setMessageID(MessageID);
            suggest.setPhyId(MedExamID);
        }
        physicalDAO.addSuggests(suggests);
        //返回数据
        return suggests;
    }

    //查询报告项目细项结果 bug：
    public MedExamItemRp getConsequence(String SourceSystem, String MessageID, Long MedExamID, Integer PageNo){
        // 数据准备
        String xmlStr = "<Request>\n" +
                "    <Header>\n" +
                "        <SourceSystem>"+SourceSystem+"</SourceSystem>\n" +
                "        <MessageID>"+MessageID+"</MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <MedExamRt>\n" +
                "            <MedExamID>"+MedExamID+"</MedExamID>\n" +
                "            <PageNo>"+PageNo+"</PageNo>\n" +
                "        </MedExamRt>\n" +
                "    </Body>\n" +
                "</Request>\n";
        //远程调用，获取到xml数据
        String result=this.sendWebService(xmlStr,"BOE0076");
        //转成对象
        Response r= XmlUtils.xmlToObject(Response.class,result);
        //插入数据库
        physicalDAO.delConsequence(MedExamID);
        String total=r.getBody().getMedExamItemRp().getTotal();
        List<Consequence> consequenceList=r.getBody().getMedExamItemRp().getConsequenceList();
        for (Consequence consequence:consequenceList) {
            consequence.setSourceSystem(SourceSystem);
            consequence.setMessageID(MessageID);
            consequence.setPhyId(MedExamID);
            consequence.setTotal(total);
            List<PhysicalConse> physicalConses=consequence.getMedExamItemDetailList().getPhysicalConseList();
            for (PhysicalConse physicalConse:physicalConses) {
                physicalConse.setConId(consequence.getId());
            }
            physicalDAO.delPhysicalConse(consequence.getId());
            physicalDAO.addPhysicalConse(physicalConses);
        }
        physicalDAO.addConsequence(consequenceList);
        //返回数据
        return r.getBody().getMedExamItemRp();
    }

    public String sendWebService(String xmlStr, String code) {
        // 接口地址
        String address = "http://123.56.71.194:13001/services/CommonService?wsdl";
        // String address = "http://localhost:13001/services/CommonService?wsdl";
        // 代理工厂
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        // 设置代理地址
        jaxWsProxyFactoryBean.setAddress(address);
        // 设置接口类型
        jaxWsProxyFactoryBean.setServiceClass(CommonService.class);
        // 创建一个代理接口实现
        CommonService cs = (CommonService) jaxWsProxyFactoryBean.create();
        // 调用代理接口的方法调用并返回xml结果
        String result = cs.synPatient(code, xmlStr);
        return result;
    }
}
