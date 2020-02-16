package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "MedExamSummaryRp")
@XmlAccessorType(XmlAccessType.FIELD)
public class MedExamSummaryRp {
    @XmlElement(name = "MedExamSummaryItem")
    private List<Suggest> suggestList;

    public List<Suggest> getSuggestList() {
        return suggestList;
    }

    public void setSuggestList(List<Suggest> suggestList) {
        this.suggestList = suggestList;
    }
}
