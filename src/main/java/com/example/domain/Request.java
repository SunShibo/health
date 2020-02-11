package com.example.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Request")
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

    public com.example.domain.Body getBody() {
        return Body;
    }

    public void setBody(com.example.domain.Body body) {
        Body = body;
    }
}
