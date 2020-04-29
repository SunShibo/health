package com.example.domain.sub;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderResponse {
    @XmlElement(name = "Header")
    private com.example.domain.Header Header;//消息来源

    @XmlElement(name = "Body")
    private SubBody Body;//消息来源

    public com.example.domain.Header getHeader() {
        return Header;
    }

    public void setHeader(com.example.domain.Header header) {
        Header = header;
    }

    public SubBody getBody() {
        return Body;
    }

    public void setBody(SubBody body) {
        Body = body;
    }
}
