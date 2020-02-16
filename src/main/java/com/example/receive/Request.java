package com.example.receive;


import com.example.domain.Header;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Request")
@XmlAccessorType(XmlAccessType.NONE)
public class Request {
    @XmlElement(name = "Header")
    private Header Header;

    @XmlElement(name = "Body")
    private Body Body;

    public com.example.domain.Header getHeader() {
        return Header;
    }

    public void setHeader(com.example.domain.Header header) {
        Header = header;
    }

    public com.example.receive.Body getBody() {
        return Body;
    }

    public void setBody(com.example.receive.Body body) {
        Body = body;
    }
}
