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
public class PersonnelRequest {


    @XmlElement(name = "Header")
    private com.example.domain.Header Header;

    @XmlElement(name = "Body")
    private PersonnelDody personnelDody;

    public com.example.domain.Header getHeader() {
        return Header;
    }

    public void setHeader(com.example.domain.Header header) {
        Header = header;
    }

    public PersonnelDody getPersonnelDody() {
        return personnelDody;
    }

    public void setPersonnelDody(PersonnelDody personnelDody) {
        this.personnelDody = personnelDody;
    }
}
