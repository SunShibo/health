package com.example.receive;

import com.example.domain.Header;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Request")
@XmlAccessorType(XmlAccessType.NONE)
public class ProjectRequest {

    @XmlElement(name = "Header")
    private com.example.domain.Header Header;

    @XmlElement(name = "Body")
    private OrderDetailBody body;


    public com.example.domain.Header getHeader() {
        return Header;
    }

    public void setHeader(com.example.domain.Header header) {
        Header = header;
    }

    public OrderDetailBody getBody() {
        return body;
    }

    public void setBody(OrderDetailBody body) {
        this.body = body;
    }
}
