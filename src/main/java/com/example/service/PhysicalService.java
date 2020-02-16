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
        result="<Response>\n" +
                "    <Header>\n" +
                "        <SourceSystem>"+SourceSystem+"</SourceSystem>\n" +
                "        <MessageID>"+MessageID+"</MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <ResultCode>0</ResultCode>\n" +
                "        <ResultContent>成功</ResultContent>\n" +
                "        <MedExamRp>\n" +
                "            <MedExamItem>\n" +
                "                <PATPATPatientName>mic1</PATPATPatientName>\n" +
                "                <SexDesc>男</SexDesc>\n" +
                "                <PATAge>27</PATAge>\n" +
                "                <MedExamDate>2016-10-20</MedExamDate>\n" +
                "                <MedExamID>1163</MedExamID>\n" +
                "                <MedExamReportStatus>已打印</MedExamReportStatus>\n" +
                "                <MedExamStatus>到达</MedExamStatus>\n" +
                "                <MedExamReservationDate>2016-10-13</MedExamReservationDate>\n" +
                "            </MedExamItem>\n" +
                "            <MedExamItem>\n" +
                "                <PATPATPatientName>mic1</PATPATPatientName>\n" +
                "                <SexDesc>男</SexDesc>\n" +
                "                <PATAge>27</PATAge>\n" +
                "                <MedExamDate>2016-10-20</MedExamDate>\n" +
                "                <MedExamID>1163</MedExamID>\n" +
                "                <MedExamReportStatus>已打印</MedExamReportStatus>\n" +
                "                <MedExamStatus>到达</MedExamStatus>\n" +
                "                <MedExamReservationDate>2016-10-13</MedExamReservationDate>\n" +
                "            </MedExamItem>\n" +
                "        </MedExamRp>\n" +
                "    </Body>\n" +
                "</Response>\n";
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
        result="<Response>\n" +
                "    <Header>\n" +
                "        <SourceSystem></SourceSystem>\n" +
                "        <MessageID></MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <ResultCode>0</ResultCode>\n" +
                "        <ResultContent>成功</ResultContent>\n" +
                "        <MedExamSummaryRp>\n" +
                "            <MedExamSummaryItem>\n" +
                "                <MedExamSummary>123312</MedExamSummary>\n" +
                "                <MedExamSummaryDoctor>123213</MedExamSummaryDoctor>\n" +
                "                <MedExamSummaryDate>123213</MedExamSummaryDate>\n" +
                "                <MedExamAuditDoctor>132</MedExamAuditDoctor>\n" +
                "                <MedExamAuditDate>2019-5-5</MedExamAuditDate>\n" +
                "            </MedExamSummaryItem>\n" +
                "            <MedExamSummaryItem>\n" +
                "                <MedExamSummary></MedExamSummary>\n" +
                "                <MedExamSummaryDoctor></MedExamSummaryDoctor>\n" +
                "                <MedExamSummaryDate></MedExamSummaryDate>\n" +
                "                <MedExamAuditDoctor></MedExamAuditDoctor>\n" +
                "                <MedExamAuditDate></MedExamAuditDate>\n" +
                "            </MedExamSummaryItem>\n" +
                "        </MedExamSummaryRp>\n" +
                "    </Body>\n" +
                "</Response>\n";
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
        result="<Response>\n" +
                "    <Header>\n" +
                "        <SourceSystem></SourceSystem>\n" +
                "        <MessageID></MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <ResultCode>0</ResultCode>\n" +
                "        <ResultContent>成功</ResultContent>\n" +
                "        <MedExamItemRp>\n" +
                "            <Total></Total>\n" +
                "            <MedExamItem>\n" +
                "                <MedExamItemDesc>123</MedExamItemDesc>\n" +
                "                <MedExamItemID>123</MedExamItemID>\n" +
                "                <MedExamItemFormat>123</MedExamItemFormat>\n" +
                "                <MedExamItemDoctor>123</MedExamItemDoctor>\n" +
                "                <MedExamItemDate></MedExamItemDate>\n" +
                "                <IsFirst></IsFirst>\n" +
                "                <IsLast></IsLast>\n" +
                "                <MedExamItemStationCode>123</MedExamItemStationCode>\n" +
                "                <MedExamItemStationName>123</MedExamItemStationName>\n" +
                "                <MedExamItemDetailList>\n" +
                "                    <MedExamItemDetailItem>\n" +
                "                        <MedExamContentDesc></MedExamContentDesc>\n" +
                "                        <MedExamContentResult></MedExamContentResult>\n" +
                "                        <MedExamContentUnit></MedExamContentUnit>\n" +
                "                        <MedExamContentRange></MedExamContentRange>\n" +
                "                    </MedExamItemDetailItem>\n" +
                "                    <MedExamItemDetailItem>\n" +
                "                        <MedExamContentDesc></MedExamContentDesc>\n" +
                "                        <MedExamContentResult></MedExamContentResult>\n" +
                "                        <MedExamContentUnit></MedExamContentUnit>\n" +
                "                        <MedExamContentRange></MedExamContentRange>\n" +
                "                    </MedExamItemDetailItem>\n" +
                "                </MedExamItemDetailList>\n" +
                "                <MedExamExceptionTip></MedExamExceptionTip>\n" +
                "            </MedExamItem>\n" +
                "            <MedExamItem>\n" +
                "                <MedExamItemDesc></MedExamItemDesc>\n" +
                "                <MedExamItemID></MedExamItemID>\n" +
                "                <MedExamItemFormat></MedExamItemFormat>\n" +
                "                <MedExamItemDoctor></MedExamItemDoctor>\n" +
                "                <MedExamItemDate>2019-2-2</MedExamItemDate>\n" +
                "                <IsFirst></IsFirst>\n" +
                "                <IsLast></IsLast>\n" +
                "                <MedExamItemStationCode></MedExamItemStationCode>\n" +
                "                <MedExamItemStationName></MedExamItemStationName>\n" +
                "                <MedExamItemDetailList>\n" +
                "                    <MedExamItemDetailItem>\n" +
                "                        <MedExamContentDesc>123</MedExamContentDesc>\n" +
                "                        <MedExamContentResult>123</MedExamContentResult>\n" +
                "                        <MedExamContentUnit>123</MedExamContentUnit>\n" +
                "                        <MedExamContentRange>123</MedExamContentRange>\n" +
                "                    </MedExamItemDetailItem>\n" +
                "                    <MedExamItemDetailItem>\n" +
                "                        <MedExamContentDesc></MedExamContentDesc>\n" +
                "                        <MedExamContentResult></MedExamContentResult>\n" +
                "                        <MedExamContentUnit></MedExamContentUnit>\n" +
                "                        <MedExamContentRange></MedExamContentRange>\n" +
                "                    </MedExamItemDetailItem>\n" +
                "                </MedExamItemDetailList>\n" +
                "                <MedExamExceptionTip></MedExamExceptionTip>\n" +
                "            </MedExamItem>\n" +
                "        </MedExamItemRp>\n" +
                "    </Body>\n" +
                "</Response>\n";
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
