package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class InformationReponse implements java.io.Serializable {
    @XmlElement( name = "Header")
    private Header header;
    @XmlElement( name = "Body" )
    private Information body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Information getBody() {
        return body;
    }

    public void setBody(Information body) {
        this.body = body;
    }
}
