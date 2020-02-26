package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ExaminationItem")
public class Consequence {
    private Long id;//报告项目详细结果
    private String SourceSystem;//消息来源
    private String MessageID;//消息ID
    private String ResultCode;//响应编码
    private String Total;//总计

    @XmlElement(name = "MedExamSummary")
    private String MedExamItemDesc;//体检项目描述
    @XmlElement(name = "MedExamItemID")
    private String MedExamItemID;//体检项目ID
    @XmlElement(name = "MedExamItemFormat")
    private String MedExamItemFormat;//体检项目格式
    @XmlElement(name = "MedExamItemDoctor")
    private String MedExamItemDoctor;//体检项目医生
    @XmlElement(name = "MedExamItemDate")
    private Date MedExamItemDate;//体检项目日期
    @XmlElement(name = "MedExamItemStationCode")
    private String MedExamItemStationCode;//体检项目站点代码
    @XmlElement(name = "MedExamItemStationName")
    private String MedExamItemStationName;//体检项目站点名称
    private Long patId;//患者id
    private Long phyId;//体检记录id
    @XmlElement(name = "IsFirst")
    private String IsFirst;//第一条
    @XmlElement(name = "IsLast")
    private String IsLast;//最后一条
    @XmlElement(name = "MedExamItemDetailList")
    private List<PhysicalConse> physicalConseList=new ArrayList<>();//体检项目详细列表（标签）
    @XmlElement(name = "MedExamExceptionTip")
    private String MedExamExceptionTip;//体检异常提示

    public Long getPhyId() {
        return phyId;
    }

    public void setPhyId(Long phyId) {
        this.phyId = phyId;
    }

    public String getMedExamExceptionTip() {
        return MedExamExceptionTip;
    }

    public void setMedExamExceptionTip(String medExamExceptionTip) {
        MedExamExceptionTip = medExamExceptionTip;
    }

    public List<PhysicalConse> getPhysicalConseList() {
        return physicalConseList;
    }

    public void setPhysicalConseList(List<PhysicalConse> physicalConseList) {
        this.physicalConseList = physicalConseList;
    }

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

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String resultCode) {
        ResultCode = resultCode;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getMedExamItemDesc() {
        return MedExamItemDesc;
    }

    public void setMedExamItemDesc(String medExamItemDesc) {
        MedExamItemDesc = medExamItemDesc;
    }

    public String getMedExamItemID() {
        return MedExamItemID;
    }

    public void setMedExamItemID(String medExamItemID) {
        MedExamItemID = medExamItemID;
    }

    public String getMedExamItemFormat() {
        return MedExamItemFormat;
    }

    public void setMedExamItemFormat(String medExamItemFormat) {
        MedExamItemFormat = medExamItemFormat;
    }

    public String getMedExamItemDoctor() {
        return MedExamItemDoctor;
    }

    public void setMedExamItemDoctor(String medExamItemDoctor) {
        MedExamItemDoctor = medExamItemDoctor;
    }

    public Date getMedExamItemDate() {
        return MedExamItemDate;
    }

    public void setMedExamItemDate(Date medExamItemDate) {
        MedExamItemDate = medExamItemDate;
    }

    public String getMedExamItemStationCode() {
        return MedExamItemStationCode;
    }

    public void setMedExamItemStationCode(String medExamItemStationCode) {
        MedExamItemStationCode = medExamItemStationCode;
    }

    public String getMedExamItemStationName() {
        return MedExamItemStationName;
    }

    public void setMedExamItemStationName(String medExamItemStationName) {
        MedExamItemStationName = medExamItemStationName;
    }

    public Long getPatId() {
        return patId;
    }

    public void setPatId(Long patId) {
        this.patId = patId;
    }

    public String getIsFirst() {
        return IsFirst;
    }

    public void setIsFirst(String isFirst) {
        IsFirst = isFirst;
    }

    public String getIsLast() {
        return IsLast;
    }

    public void setIsLast(String isLast) {
        IsLast = isLast;
    }
}
