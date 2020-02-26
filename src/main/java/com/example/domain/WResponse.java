package com.example.domain;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement(name = "Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class WResponse implements java.io.Serializable {
    @XmlElement( name = "Header")
    private Header header;
    @XmlElement( name = "Body" )
    private WBody body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public WBody getBody() {
        return body;
    }

    public void setBody(WBody body) {
        this.body = body;
    }

    public WResponse() {
        Header header=new Header();
        header.setMessageID(UUID.randomUUID().toString());
        header.setSourceSystem("platform");
        this.header=header;
    }
}
