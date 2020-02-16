package com.example.service.util;

import com.example.domain.Request;
import com.example.domain.Response;
import org.apache.logging.log4j.util.Strings;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * xml解析工具类
 */
public class XmlUtils {
    /**
     * xml字符串转对象
     * @param clazz
     * @param xmlStr
     * @return
     */
    public static <T> T xmlToObject(Class<T> clazz, String xmlStr) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xmlStr);
            T message = (T) unmarshaller.unmarshal(reader);
            return message;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对象转xml字符串
     * @param obj
     * @param load
     * @return
     * @throws JAXBException
     */
    public static String objectToXmlStr(Object obj,Class<?> load){
        String result = "";
        try{
            JAXBContext context = JAXBContext.newInstance(load);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj,writer);
            result = writer.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args){
        String string="<Response>\n" +
                "    <Header>\n" +
                "        <SourceSystem></SourceSystem>\n" +
                "        <MessageID></MessageID>\n" +
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
                "        </MedExamRp>\n" +
                "    </Body>\n" +
                "</Response>\n";
        Response r= XmlUtils.xmlToObject(Response.class,string);
        System.err.println(r.getBody().getMedExamRp().getPhysicalsList().size());
        System.err.println(r.getBody().getMedExamRp().getPhysicalsList().get(0).getPATPATPatientName());
    }
    public static void main2(String[] args){
        String xmlStr="<Request>\n" +
                "    <Header>\n" +
                "        <SourceSystem>02</SourceSystem>\n" +
                "        <MessageID>5237</MessageID>\n" +
                "    </Header>\n" +
                "    <Body>\n" +
                "        <PatientRegistryRt>\n" +
                "            <BusinessFieldCode>00001</BusinessFieldCode>\n" +
                "            <HospitalCode>医院编码</HospitalCode>\n" +
                "            <PATPatientID>101100000079</PATPatientID>\n" +
                "            <PATPatientName>宗慧测试专用</PATPatientName>\n" +
                "            <PATDob>1995-07-14</PATDob>\n" +
                "            <PATAge>23岁</PATAge>\n" +
                "            <PATSexCode>2</PATSexCode>\n" +
                "            <PATSexDesc>女</PATSexDesc>\n" +
                "            <PATMaritalStatusCode>患者婚姻状况代码</PATMaritalStatusCode>\n" +
                "            <PATMaritalStatusDesc>患者婚姻状况详情</PATMaritalStatusDesc>\n" +
                "            <PATDocumentNo>患者病案号</PATDocumentNo>\n" +
                "            <PATNationCode>01</PATNationCode>\n" +
                "            <PATNationDesc>汉族</PATNationDesc>\n" +
                "            <PATCountryCode>156</PATCountryCode>\n" +
                "            <PATCountryDesc>中国</PATCountryDesc>\n" +
                "            <PATDeceasedDate></PATDeceasedDate>\n" +
                "            <PATDeceasedTime></PATDeceasedTime>\n" +
                "            <PATHealthCardID>PATHealthCardID</PATHealthCardID>\n" +
                "            <PATMotherID>PATMotherID</PATMotherID>\n" +
                "            <PATOccupationCode>PATOccupationCode</PATOccupationCode>\n" +
                "            <PATOccupationDesc>PATOccupationDesc</PATOccupationDesc>\n" +
                "            <PATWorkPlaceName>PATWorkPlaceName</PATWorkPlaceName>\n" +
                "            <PATWorkPlaceTelNum>PATWorkPlaceTelNum</PATWorkPlaceTelNum>\n" +
                "            <PATAddressList>\n" +
                "                <PATAddress>\n" +
                "                    <PATAddressType>09</PATAddressType>\n" +
                "                    <PATAddressDesc>22222</PATAddressDesc>\n" +
                "                    <PATHouseNum></PATHouseNum>\n" +
                "                    <PATVillage></PATVillage>\n" +
                "                    <PATCountryside></PATCountryside>\n" +
                "                    <PATCountyCode></PATCountyCode>\n" +
                "                    <PATCountyDesc></PATCountyDesc>\n" +
                "                    <PATCityCode>110100</PATCityCode>\n" +
                "                    <PATCityDesc>市辖区</PATCityDesc>\n" +
                "                    <PATProvinceCode>110000</PATProvinceCode>\n" +
                "                    <PATProvinceDesc>北京市</PATProvinceDesc>\n" +
                "                    <PATPostalCode></PATPostalCode>\n" +
                "                </PATAddress>\n" +
               "            </PATAddressList>\n" +
                "            <PATIdentityList>\n" +
                "                <PATIdentity>\n" +
                "                    <PATIdentityNum>340823199507140828</PATIdentityNum>\n" +
                "                    <PATIdTypeCode>01</PATIdTypeCode>\n" +
                "                    <PATIdTypeDesc>居民身份证</PATIdTypeDesc>\n" +
                "                </PATIdentity>\n" +
                "            </PATIdentityList>\n" +
                "            <PATRelationList>\n" +
                "                <PATRelation>\n" +
                "                    <PATRelationCode>PATRelationCode</PATRelationCode>\n" +
                "                    <PATRelationDesc>PATRelationDesc</PATRelationDesc>\n" +
                "                    <PATRelationName>PATRelationName</PATRelationName>\n" +
                "                    <PATRelationPhone>PATRelationPhone</PATRelationPhone>\n" +
                "                    <PATRelationAddressList>\n" +
                "                        <PATRelationAddress>\n" +
                "                            <PATRelationAddressDesc>PATRelationAddressDesc</PATRelationAddressDesc>\n" +
                "                            <PATRelationHouseNum>PATRelationHouseNum</PATRelationHouseNum>\n" +
                "                            <PATRelationVillage>PATRelationVillage</PATRelationVillage>\n" +
                "                            <PATRelationCountryside>PATRelationCountryside</PATRelationCountryside>\n" +
                "                            <PATRelationCountyCode>PATRelationCountyCode</PATRelationCountyCode>\n" +
                "                            <PATRelationCountyDesc>PATRelationCountyDesc</PATRelationCountyDesc>\n" +
                "                            <PATRelationCityCode>PATRelationCityCode</PATRelationCityCode>\n" +
                "                            <PATRelationCityDesc>PATRelationCityDesc</PATRelationCityDesc>\n" +
                "                            <PATRelationProvinceCode>PATRelationProvinceCode</PATRelationProvinceCode>\n" +
                "                            <PATRelationProvinceDesc>PATRelationProvinceDesc</PATRelationProvinceDesc>\n" +
                "                            <PATRelationPostalCode>PATRelationPostalCode</PATRelationPostalCode>\n" +
                "                        </PATRelationAddress>\n" +
                "                    </PATRelationAddressList>\n" +
                "                </PATRelation>\n" +
                "            </PATRelationList>\n" +
                "            <PATTelephone>15656980546</PATTelephone>\n" +
                "            <PATRemarks></PATRemarks>\n" +
                "            <UpdateUserCode>SF01</UpdateUserCode>\n" +
                "            <UpdateUserDesc>SF01</UpdateUserDesc>\n" +
                "            <UpdateDate>2018-08-27</UpdateDate>\n" +
                "            <UpdateTime>19:41:16</UpdateTime>\n" +
                "        </PatientRegistryRt>\n" +
                "    </Body>\n" +
                "</Request>\n"  ;


        Request request = XmlUtils.xmlToObject(Request.class, xmlStr);
        System.out.println(request.getBody().getPatientRegistryRt().getHospitalcode());
    }
}
