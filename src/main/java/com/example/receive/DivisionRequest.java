package com.example.receive;

import com.example.domain.Header;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by wang bin
 */
@XmlRootElement(name="Request")
@XmlAccessorType(XmlAccessType.NONE)
public class DivisionRequest {

    @XmlElement(name = "Header")
    private Header Header;

    @XmlElement(name = "Body")
    private DivisionBody divisionBody;


    public com.example.domain.Header getHeader() {
        return Header;
    }

    public void setHeader(com.example.domain.Header header) {
        Header = header;
    }

    public DivisionBody getDivisionBody() {
        return divisionBody;
    }

    public void setDivisionBody(DivisionBody divisionBody) {
        this.divisionBody = divisionBody;
    }
}

