package com.example.domain.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Request")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductRequest {
    @XmlElement(name = "Header")
    private com.example.domain.Header Header;//消息来源

    @XmlElement(name = "Body")
    private ProductBody body;

    public com.example.domain.Header getHeader() {
        return Header;
    }

    public void setHeader(com.example.domain.Header header) {
        Header = header;
    }

    public ProductBody getBody() {
        return body;
    }

    public void setBody(ProductBody body) {
        this.body = body;
    }


}
