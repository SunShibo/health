package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "PATAddressList")
@XmlAccessorType(XmlAccessType.FIELD)
public class Certificate {
    @XmlElement(name = "PATIdentity")
    private List<Certificates> Certificates;

    public List<com.example.domain.Certificates> getCertificates() {
        return Certificates;
    }

    public void setCertificates(List<com.example.domain.Certificates> certificates) {
        Certificates = certificates;
    }
}
