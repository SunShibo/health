package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MedExamSummaryItem")
public class Suggest {
    private Long id;//体检建议
    private String SourceSystem;//消息来源
    private String MessageID;//消息ID
    @XmlElement(name = "MedExamSummary")
    private String MedExamSummary;//体检建议
    @XmlElement(name = "MedExamSummaryDoctor")
    private String MedExamSummaryDoctor;//体检总检医生
    @XmlElement(name = "MedExamSummaryDate")
    private String MedExamSummaryDate;//体检总检日期
    @XmlElement(name = "MedExamAuditDoctor")
    private String MedExamAuditDoctor;//体检审核医生
    @XmlElement(name = "MedExamAuditDate")
    private Date MedExamAuditDate;//体检审核日期
    private Long phyId;//体检记录id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceSystem() {
        return SourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        SourceSystem = sourceSystem;
    }

    public String getMessageID() {
        return MessageID;
    }

    public void setMessageID(String messageID) {
        MessageID = messageID;
    }

    public String getMedExamSummary() {
        return MedExamSummary;
    }

    public void setMedExamSummary(String medExamSummary) {
        MedExamSummary = medExamSummary;
    }

    public String getMedExamSummaryDoctor() {
        return MedExamSummaryDoctor;
    }

    public void setMedExamSummaryDoctor(String medExamSummaryDoctor) {
        MedExamSummaryDoctor = medExamSummaryDoctor;
    }

    public String getMedExamSummaryDate() {
        return MedExamSummaryDate;
    }

    public void setMedExamSummaryDate(String medExamSummaryDate) {
        MedExamSummaryDate = medExamSummaryDate;
    }

    public String getMedExamAuditDoctor() {
        return MedExamAuditDoctor;
    }

    public void setMedExamAuditDoctor(String medExamAuditDoctor) {
        MedExamAuditDoctor = medExamAuditDoctor;
    }

    public Date getMedExamAuditDate() {
        return MedExamAuditDate;
    }

    public void setMedExamAuditDate(Date medExamAuditDate) {
        MedExamAuditDate = medExamAuditDate;
    }

    public Long getPhyId() {
        return phyId;
    }

    public void setPhyId(Long phyId) {
        this.phyId = phyId;
    }
}
