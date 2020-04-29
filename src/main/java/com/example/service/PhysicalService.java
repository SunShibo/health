package com.example.service;

import com.example.api.CommonService;
import com.example.api.PUB0015Soap;
import com.example.dao.PhysicalDAO;
import com.example.domain.*;
import com.example.domain.sub.OrderResponse;
import com.example.receive.ProjectRequest;
import com.example.service.util.DateUtil;
import com.example.service.util.MD5Util;
import com.example.service.util.MapUtil;
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
                "        <SourceSystem>CRM</SourceSystem>\n" +
                "        <MessageID>763b2511-4b16-4707-8b07-4c540c68a551</MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <ResultCode>0</ResultCode>\n" +
                "        <ResultContent>成功</ResultContent>\n" +
                "        <CreateAppointmentInfoRp>\n" +
                "            <AppointmentNumber>SO0001000</AppointmentNumber>\n" +
                "        </CreateAppointmentInfoRp>\n" +
                "    </Body>\n" +
                "</Response>\n";
        OrderResponse orderResponse = XmlUtils.xmlToObject(OrderResponse.class, result);

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
        System.out.println("code："+code);
        System.out.println("请求入参："+xmlStr);
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
                "            <TradeCode>"+ MapUtil.getString(params,"TradeCode")+"</TradeCode>\n" +
                "            <TransactionId>"+ MapUtil.getString(params,"TransactionId")+"</TransactionId>\n" +
                "            <ExtOrgCode>"+MapUtil.getString(params,"ExtOrgCode")+"</ExtOrgCode>\n" +
                "            <ClientType>"+MapUtil.getString(params,"ClientType")+"</ClientType>\n" +
                "            <TerminalID>"+MapUtil.getString(params,"TerminalID")+"</TerminalID>\n" +
                "            <HospitalCode>"+MapUtil.getString(params,"HospitalCode")+"</HospitalCode>\n" +
                "            <UserCode>"+MapUtil.getString(params,"UserCode")+"</UserCode>\n" +
                "            <PATCardNum>"+MapUtil.getString(params,"PATCardNum")+"</PATCardNum>\n" +
                "            <PATCardType>"+MapUtil.getString(params,"PATCardType")+"</PATCardType>\n" +
                "            <PATPatientID>"+MapUtil.getString(params,"PATPatientID")+"</PATPatientID>\n" +
                "            <PATTelephone>"+MapUtil.getString(params,"PATTelephone")+"</PATTelephone>\n" +
                "            <PATIdTypeCode>"+MapUtil.getString(params,"PATIdTypeCode")+"</PATIdTypeCode>\n" +
                "            <IdentityCardNo>"+MapUtil.getString(params,"IdentityCardNo")+"</IdentityCardNo>\n" +
                "            <PATPatientName>"+MapUtil.getString(params,"PATPatientName")+"</PATPatientName>\n" +
                "            <DayPartingFlag>"+MapUtil.getString(params,"DayPartingFlag")+"</DayPartingFlag>\n" +
                "        </GetPatInfoRt>\n" +
                "    </Body>\n" +
                "</Request>\n";
        String result = this.sendWebService(request, "BOE0025");
        InformationReponse information = XmlUtils.xmlToObject(InformationReponse.class, result);
        if(information==null || !information.getBody().getResultCode().equals("0"))
        return null;
        return information.getBody().getGetPatInfoRp().getPatInfo();
    }

    public JsonResponse test(Map<String, Object> params) {
        String resultXml = this.sendWebService(MapUtil.getString(params,"xml"), MapUtil.getString(params,"code"));
        OrderResponse orderResponse = XmlUtils.xmlToObject(OrderResponse.class, resultXml);
        if( orderResponse==null){
            return new JsonResponse(orderResponse);
        }
        if("0".equals(orderResponse.getBody().getResultCode())){
            return new JsonResponse(orderResponse.getBody().getCreateAppointmentInfoRp().getAppointmentNumber());
        }
        return new JsonResponse(orderResponse.getBody().getResultCode(),orderResponse.getBody().getResultContent());
    }


    public JsonResponse reservation(Map<String, Object> params) {
        List<Map<String,Object>> list=(List<Map<String,Object>>)params.get("OEORIInfoList");
        String xml="";
        for(Map<String,Object> map:list){
            xml+="<OEORIInfo>\n" +
                    "<OEORIOrderItemID>"+MapUtil.getString(map,"OEORIOrderItemID")+"</OEORIOrderItemID>\n" +
                    "<OEORIARCItmMastCode>"+MapUtil.getString(map,"OEORIARCItmMastCode")+"</OEORIARCItmMastCode>\n" +
                    "<OEORIARCItmMastDesc>"+MapUtil.getString(map,"OEORIARCItmMastDesc")+"</OEORIARCItmMastDesc>\n" +
                    "<OEORIARCItmMastType>"+MapUtil.getString(map,"OEORIARCItmMastType")+"</OEORIARCItmMastType>\n" +
                    "<OEORIOrderQty>"+MapUtil.getString(map,"OEORIOrderQty")+"</OEORIOrderQty>\n" +
                    "<OEOPackageDetailPrice>"+MapUtil.getString(map,"OEOPackageDetailPrice")+"</OEOPackageDetailPrice>\n" +
                 "</OEORIInfo>";
        }
        String body="<Body>\n" +
                "        <CreateAppointmentInfoRt>\n" +
                "            <SalesOrderNumber>"+MapUtil.getString(params,"SalesOrderNumber")+"</SalesOrderNumber>\n" +
                "            <DataSource>"+MapUtil.getString(params,"DataSource")+"</DataSource>\n" +
                "            <DataSourceDesc>"+MapUtil.getString(params,"DataSourceDesc")+"</DataSourceDesc>\n" +
                "            <UserCode>"+MapUtil.getString(params,"UserCode")+"</UserCode>\n" +
                "            <DeptCode>"+MapUtil.getString(params,"DeptCode")+"</DeptCode>\n" +
                "            <UpdateUserDesc>"+MapUtil.getString(params,"UpdateUserDesc")+"</UpdateUserDesc>\n" +
                "            <CheckoutCompanyCode>"+MapUtil.getString(params,"CheckoutCompanyCode")+"</CheckoutCompanyCode>\n" +
                "            <CheckoutCompanyDesc>"+MapUtil.getString(params,"CheckoutCompanyDesc")+"</CheckoutCompanyDesc>\n" +
                "            <ProjectNumber>"+MapUtil.getString(params,"ProjectNumber")+"</ProjectNumber>\n" +
                "            <ProjectName>"+MapUtil.getString(params,"ProjectName")+"</ProjectName>\n" +
                "            <BatchNumber>"+MapUtil.getString(params,"BatchNumber")+"</BatchNumber>\n" +
                "            <HospitalCode>"+MapUtil.getString(params,"HospitalCode")+"</HospitalCode>\n" +
                "            <ParentAccountDesc>"+MapUtil.getString(params,"ParentAccountDesc")+"</ParentAccountDesc>\n" +
                "            <ParentAccountCode>"+MapUtil.getString(params,"ParentAccountCode")+"</ParentAccountCode>\n" +
                "            <PATPatientName>"+MapUtil.getString(params,"PATPatientName")+"</PATPatientName>\n" +
                "            <PATDob>"+MapUtil.getString(params,"PATDob")+"</PATDob>\n" +
                "            <PATSexCode>"+MapUtil.getString(params,"PATSexCode")+"</PATSexCode>\n" +
                "            <PATMaritalStatusCode>"+MapUtil.getString(params,"PATMaritalStatusCode")+"</PATMaritalStatusCode>\n" +
                "            <CertificatesType>"+MapUtil.getString(params,"CertificatesType")+"</CertificatesType>\n" +
                "            <PATIdentityNum>"+MapUtil.getString(params,"PATIdentityNum")+"</PATIdentityNum>\n" +
                "            <PATTelephone>"+MapUtil.getString(params,"PATTelephone")+"</PATTelephone>\n" +
                "            <BillStatus>"+MapUtil.getString(params,"BillStatus")+"</BillStatus>\n" +
                "            <TotalAmount>"+MapUtil.getString(params,"TotalAmount")+"</TotalAmount>\n" +
                "            <ValidStartDate>"+MapUtil.getString(params,"ValidStartDate")+"</ValidStartDate>\n" +
                "            <OEORIInfoList>\n"+xml+"\n"+
                "        </CreateAppointmentInfoRt>\n" +
                "</Body>";
        String dataSecret= MD5Util.EncodeByMD5(body+MD5Util.EncodeByMD5(body));

        String header="<Request>\n" +
                "    <Header>\n" +
                "        <SourceSystem>platform</SourceSystem>\n" +
                "        <MessageID></MessageID>\n" +
                "        <DataSecret>"+dataSecret+"</DataSecret>\n" +
                "        <RequestTime>"+DateUtil.getNow()+"</RequestTime>\n" +
                "    </Header>\n" +
                     body+
                "</Request>" ;
        String resultXml = this.sendWebService(header,"BOE0229");
        OrderResponse orderResponse = XmlUtils.xmlToObject(OrderResponse.class, resultXml);
        if( orderResponse==null){
            return new JsonResponse(orderResponse);
        }
        if("0".equals(orderResponse.getBody().getResultCode())){
            return new JsonResponse(orderResponse.getBody().getCreateAppointmentInfoRp().getAppointmentNumber());
        }
        return new JsonResponse(orderResponse.getBody().getResultCode(),orderResponse.getBody().getResultContent());
    }
}
