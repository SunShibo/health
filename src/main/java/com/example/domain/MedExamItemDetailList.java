package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MedExamItemDetailList")
public class MedExamItemDetailList {
    @XmlElement(name = "MedExamItemDetailItem")
    private List<PhysicalConse> physicalConseList=new ArrayList<>();

    public List<PhysicalConse> getPhysicalConseList() {
        return physicalConseList;
    }

    public void setPhysicalConseList(List<PhysicalConse> physicalConseList) {
        this.physicalConseList = physicalConseList;
    }
}
