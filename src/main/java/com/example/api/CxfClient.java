package com.example.api;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
 

public class CxfClient {

 
    /**
     * 方式1.代理类工厂的方式,需要拿到对方的接口
     */
    public static void cl1() {
        try {
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
            // 数据准备
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
            String userName = "<xml>测试</xml>";
            // 调用代理接口的方法调用并返回结果
            String result = cs.synPatient("T0004",xmlStr);
          System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        cl1();
    }
    /**
     * 动态调用方式
     */
    public static void cl2() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/services/CommonService?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
        // PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("sayHello", "Leftso");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void cl3() {
        try {
            // 接口地址
            String address = "http://123.56.71.194:13001/services/CommonService?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(CommonService.class);
            // 创建一个代理接口实现
            CommonService cs = (CommonService) jaxWsProxyFactoryBean.create();
            // 数据准备
            String xmlStr="<Request>\n" +
                    "    <Header>\n" +
                    "        <SourceSystem>BOE0074</SourceSystem>\n" +
                    "        <MessageID></MessageID>\n" +
                    "    </Header>\n" +
                    "    <Body>\n" +
                    "        <MedExamRt>\n" +
                    "            <PATPatientID>101100000072</PATPatientID>\n" +
                    "        </MedExamRt>\n" +
                    "    </Body>\n" +
                    "</Request>\n";
            // 调用代理接口的方法调用并返回结果
            String result = cs.synPatient("BOE0074",xmlStr);
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}