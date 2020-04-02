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
     //      String address = "http://123.56.71.194:13001/services/CommonService?wsdl";
             String address = "http://localhost:13001/services/CommonService?wsdl";
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
                    "        <SourceSystem> SourceSystem </SourceSystem>\n" +
                    "        <MessageID> MessageID </MessageID>\n" +
                    "    </Header>\n" +
                    "<Body>\n" +
                    "    <CT_PE_OrderDetailRelate>\n" +
                    "        <ODR_StationCode> StationCode </ODR_StationCode>\n" +
                    "<ODR_StationDesc> StationDesc </ODR_StationDesc>\n" +
                    "<ODR_ItemCode> ItemCode </ODR_ItemCode>\n" +
                    "<ODR_ItemDesc> ItemDesc </ODR_ItemDesc>\n" +
                    "<ItemDetailList>\n" +
                    "   <ItemDetail>\n" +
                    "      <ODR_ItemDetailCode> Code</ODR_ItemDetailCode>\n" +
                    "<ODR_ItemDetailDesc>desc</ODR_ItemDetailDesc>\n" +
                    "<ODR_Sequence>ce</ODR_Sequence>\n" +
                    "<ODR_Required>red</ODR_Required>\n" +
                    "   </ItemDetail>\n" +
                    "   <ItemDetail>\n" +
                    "      <ODR_ItemDetailCode>cd</ODR_ItemDetailCode>\n" +
                    "<ODR_ItemDetailDesc>desc</ODR_ItemDetailDesc>\n" +
                    "<ODR_Sequence>seqs</ODR_Sequence>\n" +
                    "<ODR_Required>res</ODR_Required>\n" +
                    "   </ItemDetail>\n" +
                    "</ItemDetailList>\n" +
                    "</CT_PE_OrderDetailRelate>\n" +
                    "    </Body>\n" +
                    "</Request>\n";
            String userName = "<xml>测试</xml>";
            // 调用代理接口的方法调用并返回结果
            String result = cs.synPatient("BOE0279",xmlStr);
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