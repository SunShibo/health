package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "PATRelationAddressList")
@XmlAccessorType(XmlAccessType.FIELD)
public class PATRelationAddressList {

    @XmlElement(name = "PATRelationAddress")
    private List<ConsAddress> consAddressList;

    public List<ConsAddress> getConsAddressList() {
        return consAddressList;
    }

    public void setConsAddressList(List<ConsAddress> consAddressList) {
        this.consAddressList = consAddressList;
    }
}
