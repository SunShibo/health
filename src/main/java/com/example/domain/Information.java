package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Body")
@XmlAccessorType(XmlAccessType.FIELD)
public class Information {

    @XmlElement( name = "ResultCode" ) //相应编码
    private String ResultCode;
    @XmlElement( name = "ResultContent" ) //相应状态信息
    private String ResultContent;
    @XmlElement( name = "GetPatInfoRp" )
    private GetPatInfoRp GetPatInfoRp;   //相应对象

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

    public com.example.domain.GetPatInfoRp getGetPatInfoRp() {
        return GetPatInfoRp;
    }

    public void setGetPatInfoRp(com.example.domain.GetPatInfoRp getPatInfoRp) {
        GetPatInfoRp = getPatInfoRp;
    }
}
