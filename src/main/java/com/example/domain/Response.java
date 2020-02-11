package com.example.domain;


import javax.xml.bind.annotation.*;
import java.util.UUID;

@XmlRootElement(name = "Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response  implements java.io.Serializable {
    @XmlElement( name = "Header")
    private Header header;
    @XmlElement( name = "Body" )
    private SBody body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public SBody getBody() {
        return body;
    }

    public void setBody(SBody body) {
        this.body = body;
    }

    public Response() {
        Header header=new Header();
        header.setMessageID(UUID.randomUUID().toString());
        header.setSourceSystem("platform");
        this.header=header;
    }
}
