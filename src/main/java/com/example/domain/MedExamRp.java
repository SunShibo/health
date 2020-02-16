package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "MedExamRp")
@XmlAccessorType(XmlAccessType.FIELD)
public class MedExamRp {

    @XmlElement(name = "MedExamItem")
    private List<Physical> physicalsList;

    public List<Physical> getPhysicalsList() {
        return physicalsList;
    }

    public void setPhysicalsList(List<Physical> physicalsList) {
        this.physicalsList = physicalsList;
    }
}
