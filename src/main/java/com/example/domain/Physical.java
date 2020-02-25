package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MedExamItem")
public class Physical {
    private Long id;//体检记录

    @XmlElement(name = "SourceSystem")
    private String SourceSystem;//信息来源
    @XmlElement(name = "MessageID")
    private String MessageID;//消息ID
    @XmlElement(name = "PATPATPatientName")
    private String PATPATPatientName;//患者姓名
    @XmlElement(name = "SexDesc")
    private String SexDesc;//患者性别描述
    @XmlElement(name = "PATAge")
    private String PATAge;//患者年龄
    @XmlElement(name = "MedExamDate")
    private Date MedExamDate;//体检日期
    @XmlElement(name = "MedExamID")
    private String MedExamID;//体检ID
    @XmlElement(name = "MedExamReportStatus")
    private String MedExamReportStatus;//体检报告状态
    @XmlElement(name = "MedExamStatus")
    private String MedExamStatus;//体检状态
    @XmlElement(name = "MedExamReservationDate")
    private String MedExamReservationDate;//体检预约时间
    @XmlElement(name = "PackageDesc") //体检号
    private String PackageDesc;
    @XmlElement(name = "HPNo") //体检号
    private String HPNo;
    private Long patId;//患者id

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

    public String getPATPATPatientName() {
        return PATPATPatientName;
    }

    public void setPATPATPatientName(String PATPATPatientName) {
        this.PATPATPatientName = PATPATPatientName;
    }

    public String getSexDesc() {
        return SexDesc;
    }

    public void setSexDesc(String sexDesc) {
        SexDesc = sexDesc;
    }

    public String getPATAge() {
        return PATAge;
    }

    public void setPATAge(String PATAge) {
        this.PATAge = PATAge;
    }

    public Date getMedExamDate() {
        return MedExamDate;
    }

    public void setMedExamDate(Date medExamDate) {
        MedExamDate = medExamDate;
    }

    public String getMedExamID() {
        return MedExamID;
    }

    public void setMedExamID(String medExamID) {
        MedExamID = medExamID;
    }

    public String getMedExamReportStatus() {
        return MedExamReportStatus;
    }

    public void setMedExamReportStatus(String medExamReportStatus) {
        MedExamReportStatus = medExamReportStatus;
    }

    public String getMedExamStatus() {
        return MedExamStatus;
    }

    public void setMedExamStatus(String medExamStatus) {
        MedExamStatus = medExamStatus;
    }

    public String getMedExamReservationDate() {
        return MedExamReservationDate;
    }

    public void setMedExamReservationDate(String medExamReservationDate) {
        MedExamReservationDate = medExamReservationDate;
    }

    public Long getPatId() {
        return patId;
    }

    public void setPatId(Long patId) {
        this.patId = patId;
    }

    public String getPackageDesc() {
        return PackageDesc;
    }

    public void setPackageDesc(String packageDesc) {
        PackageDesc = packageDesc;
    }

    public String getHPNo() {
        return HPNo;
    }

    public void setHPNo(String HPNo) {
        this.HPNo = HPNo;
    }
}
