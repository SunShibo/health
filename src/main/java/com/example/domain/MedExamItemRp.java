package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "MedExamRp")
@XmlAccessorType(XmlAccessType.FIELD)
public class MedExamItemRp {
    @XmlElement(name = "Total")
    private String Total;

    @XmlElement(name = "ExaminationItem")
    private List<Consequence>  consequenceList;

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public List<Consequence> getConsequenceList() {
        return consequenceList;
    }

    public void setConsequenceList(List<Consequence> consequenceList) {
        this.consequenceList = consequenceList;
    }
}
