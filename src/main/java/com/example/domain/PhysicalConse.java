package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MedExamItemDetailItem")
public class PhysicalConse {
    @XmlElement(name = "MedExamContentDesc")
    private String MedExamContentDesc;//体检内容描述
    @XmlElement(name = "MedExamContentResult")
    private String MedExamContentResult;//体检内容结果
    @XmlElement(name = "MedExamContentUnit")
    private String MedExamContentUnit;//体检内容单位
    @XmlElement(name = "MedExamContentRange")
    private String MedExamContentRange;//体检内容范围
    private Long  conId;//consequence  Id

    public Long getConId() {
        return conId;
    }

    public void setConId(Long conId) {
        this.conId = conId;
    }

    public String getMedExamContentResult() {
        return MedExamContentResult;
    }

    public void setMedExamContentResult(String medExamContentResult) {
        MedExamContentResult = medExamContentResult;
    }

    public String getMedExamContentDesc() {
        return MedExamContentDesc;
    }

    public void setMedExamContentDesc(String medExamContentDesc) {
        MedExamContentDesc = medExamContentDesc;
    }

    public String getMedExamContentUnit() {
        return MedExamContentUnit;
    }

    public void setMedExamContentUnit(String medExamContentUnit) {
        MedExamContentUnit = medExamContentUnit;
    }

    public String getMedExamContentRange() {
        return MedExamContentRange;
    }

    public void setMedExamContentRange(String medExamContentRange) {
        MedExamContentRange = medExamContentRange;
    }
}
