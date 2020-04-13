package com.example.service;

import com.example.api.CommonService;
import com.example.api.PUB0015Soap;
import com.example.dao.PhysicalDAO;
import com.example.domain.*;
import com.example.receive.ProjectRequest;
import com.example.service.util.XmlUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PhysicalService {

    @Autowired
    PhysicalDAO physicalDAO;

    //根据患者索引查询历次体检记录，bug：不确定患者索引类型
    public List<Physical> getList(String SourceSystem, String MessageID, String PATPatientID) {
        // 数据准备
        String xmlStr = "<Request>\n" +
                "    <Header>\n" +
                "        <SourceSystem>" + "platform" + "</SourceSystem>\n" +
                "        <MessageID>" + MessageID + "</MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <MedExamRt>\n" +
                "            <PATPatientID>" + PATPatientID + "</PATPatientID>\n" +
                "        </MedExamRt>\n" +
                "    </Body>\n" +
                "</Request>\n";
        //远程调用，获取到xml数据
        String result = this.sendWebService(xmlStr, "BOE0074");
        if (result == null ||  result.equals("")) {
            return null;
        }
        //转成对象
        Response r = XmlUtils.xmlToObject(Response.class, result);
        //插入数据库
        physicalDAO.delPhysical(new Long(PATPatientID));
        List<Physical> physicalList = r.getBody().getMedExamRp().getPhysicalsList();

        if (physicalList == null) {
            return null;
        }
        for (Physical physical : physicalList) {
            physical.setSourceSystem(r.getHeader().getSourceSystem());
            physical.setMessageID(r.getHeader().getMessageID());
            physical.setPatId(new Long(PATPatientID));
        }

        physicalDAO.addPhysical(physicalList);
        //返回数据
        return r.getBody().getMedExamRp().getPhysicalsList();
    }

    //根据体检记录查询建议bug：不确定一条体检记录对应几条建议,目前按文档的多条做的
    public List<Suggest> getSuggest(String SourceSystem, String MessageID, Long MedExamID) {
        // 数据准备
        String xmlStr = "<Request>\n" +
                "    <Header>\n" +
                "        <SourceSystem>"  + "platform" + "</SourceSystem>\n" +
                "        <MessageID>" + MessageID + "</MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <MedExamSummaryRt>\n" +
                "            <MedExamID>" + MedExamID + "</MedExamID>\n" +
                "        </MedExamSummaryRt>\n" +
                "    </Body>\n" +
                "</Request>\n";
        //远程调用，获取到xml数据
        String result = this.sendWebService(xmlStr, "BOE0075");
        if (result == null || result.equals("")) {
            return null;
        }
        //转成对象
        Response r = XmlUtils.xmlToObject(Response.class, result);
        //插入数据库
        physicalDAO.delSuggests(MedExamID);
        List<Suggest> suggests = r.getBody().getMedExamSummaryRp().getSuggestList();
        for (Suggest suggest : suggests) {
            suggest.setSourceSystem(r.getHeader().getSourceSystem());
            suggest.setMessageID(r.getHeader().getMessageID());
            suggest.setPhyId(MedExamID);
        }
        physicalDAO.addSuggests(suggests);
        //返回数据
        return suggests;
    }

    //查询报告项目细项结果 bug：
    public MedExamItemRp getConsequence(String SourceSystem, String MessageID, Long MedExamID, String PageNo) {
        // 数据准备
        String xmlStr = "<Request>\n" +
                "    <Header>\n" +
                "        <SourceSystem>" + "platform" + "</SourceSystem>\n" +
                "        <MessageID>" + MessageID + "</MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <MedExamRt>\n" +
                "            <MedExamID>" + MedExamID + "</MedExamID>\n" +
                "            <PageNo>" + PageNo + "</PageNo>\n" +
                "        </MedExamRt>\n" +
                "    </Body>\n" +
                "</Request>\n";
        //远程调用，获取到xml数据
        String result = this.sendWebService(xmlStr, "BOE0076");
        if (result == null || result.equals("")) {
            return null;
        }
        //转成对象
        WResponse r = XmlUtils.xmlToObject(WResponse.class, result);
        if(!"0".equals(r.getBody().getResultCode())){
            return null;
        }
        //插入数据库

        physicalDAO.delConsequence(MedExamID);
        System.out.println(r.getBody().getMedExamItemRp());
        String total = r.getBody().getMedExamItemRp().getTotal();
        List<Consequence> consequenceList = r.getBody().getMedExamItemRp().getConsequenceList();
        for (Consequence consequence : consequenceList) {
            consequence.setSourceSystem(r.getHeader().getSourceSystem());
            consequence.setMessageID(r.getHeader().getMessageID());
            consequence.setPhyId(MedExamID);
            consequence.setTotal(total);
            List<PhysicalConse> physicalConses = consequence.getPhysicalConseList();
            for (PhysicalConse physicalConse : physicalConses) {///问题点
                physicalConse.setConId(consequence.getId());
            }
            physicalDAO.delPhysicalConse(consequence.getId());
            if(physicalConses!=null&&physicalConses.size()!=0){
                physicalDAO.addPhysicalConse(physicalConses);

            }
        }
        physicalDAO.addConsequence(consequenceList);
        //返回数据
        return r.getBody().getMedExamItemRp();
    }

    public static void main(String[] args) {
        String result="<Response>\n" +
                "    <Header>\n" +
                "        <MessageID>3658</MessageID>\n" +
                "        <SourceSystem>02</SourceSystem>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <ResultCode>0</ResultCode>\n" +
                "        <ResultContent>成功</ResultContent>\n" +
                "        <GetPatInfoRp>\n" +
                "            <PatInfo>\n" +
                "                <PATPatientID>101100000072</PATPatientID>\n" +
                "                <PATPatientName>张三</PATPatientName>\n" +
                "                <PATSexDesc>男</PATSexDesc>\n" +
                "                <PATSexCode>1</PATSexCode>\n" +
                "                <PATDob>2011-01-01</PATDob>\n" +
                "                <TelephoneNo>15123454321</TelephoneNo>\n" +
                "                <PATTelephone>15123454321</PATTelephone>\n" +
                "                <PATDocumentNo></PATDocumentNo>\n" +
                "                <PATPatientAddress></PATPatientAddress>\n" +
                "                <PATIdTypeCode>20</PATIdTypeCode>\n" +
                "                <PATIdTypeDesc></PATIdTypeDesc>\n" +
                "                <PATIdentityNum>320282199912144879</PATIdentityNum>\n" +
                "                <InsureCardNo>ZHANGSAN</InsureCardNo>\n" +
                "                <AccInfo>0^37534^1011000000720001^24^24^0^^72^101100000072^50007^P^PC^1^^0^37534^1011000000720001^24^24^0^^72^101100000072^50007^P^PC^1^</AccInfo>\n" +
                "                <AccountBalance>24</AccountBalance>\n" +
                "                <AccountID>37534</AccountID>\n" +
                "                <PATCardNum>101100000072</PATCardNum>\n" +
                "                <YBFlag>0</YBFlag>\n" +
                "                <PATType>自费</PATType>\n" +
                "                <PatTypeCode>01</PatTypeCode>\n" +
                "            </PatInfo>\n" +
                "        </GetPatInfoRp>\n" +
                "    </Body>\n" +
                "</Response>\n";
        InformationReponse information = XmlUtils.xmlToObject(InformationReponse.class, result);
    }



    public String sendWebService(String xmlStr, String code) {
        // 接口地址
        String address = "http://60.174.197.150:57772/csp/hsb/DHC.Published.PUB0015.BS.PUB0015.CLS";
        // String address = "http://localhost:13001/services/CommonService?wsdl";
        // 代理工厂
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        System.out.println("代理工厂 .....");
        // 设置代理地址
        jaxWsProxyFactoryBean.setAddress(address);
        System.out.println("设置代理地址 .....");
        // 设置接口类型
        jaxWsProxyFactoryBean.setServiceClass(PUB0015Soap.class);
        System.out.println("设置接口类型 .....");
        // 创建一个代理接口实现
        PUB0015Soap cs = (PUB0015Soap) jaxWsProxyFactoryBean.create();
        System.out.println("创建一个代理接口实现 .....");
        // 调用代理接口的方法调用并返回xml结果
        String result = cs.hipMessageServer(code, xmlStr);
        System.out.println("调用代理接口的方法调用并返回xml结果 ....." +result);
        return result;
    }


    public PatInfo information(Map<String, Object> params) {
        String request="<Request>\n" +
                "    <Header>\n" +
                "        <SourceSystem>platform</SourceSystem>\n" +
                "        <MessageID>"+params.get("MessageID")+"</MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <GetPatInfoRt>\n" +
                "            <TradeCode>"+params.get("TradeCode")+"</TradeCode>\n" +
                "            <TransactionId>"+params.get("TransactionId")+"</TransactionId>\n" +
                "            <ExtOrgCode>"+params.get("ExtOrgCode")+"</ExtOrgCode>\n" +
                "            <ClientType>"+params.get("ClientType")+"</ClientType>\n" +
                "            <TerminalID>"+params.get("TerminalID")+"</TerminalID>\n" +
                "            <HospitalCode>"+params.get("HospitalCode")+"</HospitalCode>\n" +
                "            <UserCode>"+params.get("UserCode")+"</UserCode>\n" +
                "            <PATCardNum>"+params.get("PATCardNum")+"</PATCardNum>\n" +
                "            <PATCardType>"+params.get("PATCardType")+"</PATCardType>\n" +
                "            <PATPatientID>"+params.get("PATPatientID")+"</PATPatientID>\n" +
                "            <PATTelephone>"+params.get("PATTelephone")+"</PATTelephone>\n" +
                "            <PATIdTypeCode>"+params.get("PATIdTypeCode")+"</PATIdTypeCode>\n" +
                "            <IdentityCardNo>"+params.get("IdentityCardNo")+"</IdentityCardNo>\n" +
                "            <PATPatientName>"+params.get("PATPatientName")+"</PATPatientName>\n" +
                "            <DayPartingFlag>"+params.get("DayPartingFlag")+"</DayPartingFlag>\n" +
                "        </GetPatInfoRt>\n" +
                "    </Body>\n" +
                "</Request>\n";
        String result = this.sendWebService(request, "BOE0025");
        InformationReponse information = XmlUtils.xmlToObject(InformationReponse.class, result);
        if(information==null || !information.getBody().getResultCode().equals("0"))
        return null;
        return information.getBody().getGetPatInfoRp().getPatInfo();
    }
}
