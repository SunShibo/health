package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Body")
@XmlAccessorType(XmlAccessType.FIELD)
public class SBody {

    @XmlElement(name = "ResultCode")
    private String ResultCode; //响应编码  0:成功  -1:失败
    @XmlElement(name = "ResultContent")
    private String ResultContent; // 返回响应结果

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String resultCode) {
        ResultCode = resultCode;
    }

    public String getResultContent() {
        return ResultContent;
    }

    public void setResultContent(String resultContent) {
        ResultContent = resultContent;
    }
}
