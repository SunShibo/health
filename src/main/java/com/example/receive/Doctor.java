package com.example.receive;

import javafx.fxml.FXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by wang bin
 */
@XmlRootElement(name = "HMSMessageRt")
@XmlAccessorType(XmlAccessType.NONE)
public class Doctor implements Serializable {

    @XmlElement(name = "SourceSystem")
    private String SourceSystem;//消息来源
    @XmlElement(name = "MessageID")
    private String MessageID;//消息Id

    @XmlElement
    private String HospitalCode;

    @XmlElement
    private String PATPatientID;

    @XmlElement
    private String MedExamNumber;

    @XmlElement
    private String RecordDate;

    @XmlElement
    private String OEORIOrderItemID;

    @XmlElement
    private String OEORIARCItmMastDesc;

    @XmlElement
    private String TriggerFlag;

    public void setHospitalCode(String hospitalCode) {
        HospitalCode = hospitalCode;
    }

    public String getPATPatientID() {
        return PATPatientID;
    }

    public void setPATPatientID(String PATPatientID) {
        this.PATPatientID = PATPatientID;
    }

    public String getMedExamNumber() {
        return MedExamNumber;
    }

    public void setMedExamNumber(String medExamNumber) {
        MedExamNumber = medExamNumber;
    }

    public String getRecordDate() {
        return RecordDate;
    }

    public void setRecordDate(String recordDate) {
        RecordDate = recordDate;
    }

    public String getOEORIOrderItemID() {
        return OEORIOrderItemID;
    }

    public void setOEORIOrderItemID(String OEORIOrderItemID) {
        this.OEORIOrderItemID = OEORIOrderItemID;
    }

    public String getOEORIARCItmMastDesc() {
        return OEORIARCItmMastDesc;
    }

    public void setOEORIARCItmMastDesc(String OEORIARCItmMastDesc) {
        this.OEORIARCItmMastDesc = OEORIARCItmMastDesc;
    }

    public String getTriggerFlag() {
        return TriggerFlag;
    }

    public void setTriggerFlag(String triggerFlag) {
        TriggerFlag = triggerFlag;
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

    public String getHospitalCode() {
        return HospitalCode;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "SourceSystem='" + SourceSystem + '\'' +
                ", MessageID='" + MessageID + '\'' +
                ", HospitalCode='" + HospitalCode + '\'' +
                ", PATPatientID='" + PATPatientID + '\'' +
                ", MedExamNumber='" + MedExamNumber + '\'' +
                ", RecordDate='" + RecordDate + '\'' +
                ", OEORIOrderItemID='" + OEORIOrderItemID + '\'' +
                ", OEORIARCItmMastDesc='" + OEORIARCItmMastDesc + '\'' +
                ", TriggerFlag='" + TriggerFlag + '\'' +
                '}';
    }
}
