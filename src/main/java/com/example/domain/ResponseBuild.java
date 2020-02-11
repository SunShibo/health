package com.example.domain;

import com.example.service.util.XmlUtils;

public class ResponseBuild {


    public static String success(){
        Response  response = new Response();
        SBody sBody=new SBody();
        sBody.setResultCode("0");
        sBody.setResultContent("成功");
        response.setBody(sBody);
        return XmlUtils.objectToXmlStr(response,Response.class);
    }

    public static String failure(String errMsg){
        Response  response = new Response();
        SBody sBody=new SBody();
        sBody.setResultCode("-1");
        sBody.setResultContent(errMsg);
        response.setBody(sBody);
        return XmlUtils.objectToXmlStr(response,Response.class);

    }

}
