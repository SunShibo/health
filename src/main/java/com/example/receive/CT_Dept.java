package com.example.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by wang bin
 */
@XmlRootElement(name="CT_Dept")
@XmlAccessorType(XmlAccessType.NONE)
public class CT_Dept {

    @XmlElement
    private String CTD_Code;

    @XmlElement
    private String CTD_Desc;

    @XmlElement
    private String CTD_CategoryCode;

    @XmlElement
    private String CTD_Phonetic;

    @XmlElement
    private String CTD_WardFlag;

    @XmlElement
    private String BusinessFieldCode;

    @XmlElement
    private String CTD_CreatDate;

    @XmlElement
    private String CTD_CreatTime;

    @XmlElement
    private String CTD_UpdateDate;

    @XmlElement
    private String CTD_UpdateTime;

    @XmlElement
    private String CTD_OriginalCode;

    @XmlElement
    private String CTD_OriginalDesc;

    @XmlElement
    private String CTD_Remarks;

    @XmlElement
    private String CTD_StartDate;

    @XmlElement
    private String CTD_EndDate;

    @XmlElement
    private String CTD_CodesystemCode;

    @XmlElement
    private String CTD_OfficeAddress;

    @XmlElement
    private String CTD_OfficePhone;

    @XmlElement
    private String CTD_UpdateUserCode;

    @XmlElement
    private String CTD_HosCode;

    @XmlElement
    private String CTD_DepartmentGroup;

    @XmlElement
    private String CTD_AdmType;

    @XmlElement
    private String CTD_ParentCode;

    @XmlElement
    private String CTD_Status;

    public String getCTD_Code() {
        return CTD_Code;
    }

    public void setCTD_Code(String CTD_Code) {
        this.CTD_Code = CTD_Code;
    }

    public String getCTD_Desc() {
        return CTD_Desc;
    }

    public void setCTD_Desc(String CTD_Desc) {
        this.CTD_Desc = CTD_Desc;
    }

    public String getCTD_CategoryCode() {
        return CTD_CategoryCode;
    }

    public void setCTD_CategoryCode(String CTD_CategoryCode) {
        this.CTD_CategoryCode = CTD_CategoryCode;
    }

    public String getCTD_Phonetic() {
        return CTD_Phonetic;
    }

    public void setCTD_Phonetic(String CTD_Phonetic) {
        this.CTD_Phonetic = CTD_Phonetic;
    }

    public String getCTD_WardFlag() {
        return CTD_WardFlag;
    }

    public void setCTD_WardFlag(String CTD_WardFlag) {
        this.CTD_WardFlag = CTD_WardFlag;
    }

    public String getBusinessFieldCode() {
        return BusinessFieldCode;
    }

    public void setBusinessFieldCode(String businessFieldCode) {
        BusinessFieldCode = businessFieldCode;
    }

    public String getCTD_CreatDate() {
        return CTD_CreatDate;
    }

    public void setCTD_CreatDate(String CTD_CreatDate) {
        this.CTD_CreatDate = CTD_CreatDate;
    }

    public String getCTD_CreatTime() {
        return CTD_CreatTime;
    }

    public void setCTD_CreatTime(String CTD_CreatTime) {
        this.CTD_CreatTime = CTD_CreatTime;
    }

    public String getCTD_UpdateDate() {
        return CTD_UpdateDate;
    }

    public void setCTD_UpdateDate(String CTD_UpdateDate) {
        this.CTD_UpdateDate = CTD_UpdateDate;
    }

    public String getCTD_UpdateTime() {
        return CTD_UpdateTime;
    }

    public void setCTD_UpdateTime(String CTD_UpdateTime) {
        this.CTD_UpdateTime = CTD_UpdateTime;
    }

    public String getCTD_OriginalCode() {
        return CTD_OriginalCode;
    }

    public void setCTD_OriginalCode(String CTD_OriginalCode) {
        this.CTD_OriginalCode = CTD_OriginalCode;
    }

    public String getCTD_OriginalDesc() {
        return CTD_OriginalDesc;
    }

    public void setCTD_OriginalDesc(String CTD_OriginalDesc) {
        this.CTD_OriginalDesc = CTD_OriginalDesc;
    }

    public String getCTD_Remarks() {
        return CTD_Remarks;
    }

    public void setCTD_Remarks(String CTD_Remarks) {
        this.CTD_Remarks = CTD_Remarks;
    }

    public String getCTD_StartDate() {
        return CTD_StartDate;
    }

    public void setCTD_StartDate(String CTD_StartDate) {
        this.CTD_StartDate = CTD_StartDate;
    }

    public String getCTD_EndDate() {
        return CTD_EndDate;
    }

    public void setCTD_EndDate(String CTD_EndDate) {
        this.CTD_EndDate = CTD_EndDate;
    }

    public String getCTD_CodesystemCode() {
        return CTD_CodesystemCode;
    }

    public void setCTD_CodesystemCode(String CTD_CodesystemCode) {
        this.CTD_CodesystemCode = CTD_CodesystemCode;
    }

    public String getCTD_OfficeAddress() {
        return CTD_OfficeAddress;
    }

    public void setCTD_OfficeAddress(String CTD_OfficeAddress) {
        this.CTD_OfficeAddress = CTD_OfficeAddress;
    }

    public String getCTD_OfficePhone() {
        return CTD_OfficePhone;
    }

    public void setCTD_OfficePhone(String CTD_OfficePhone) {
        this.CTD_OfficePhone = CTD_OfficePhone;
    }

    public String getCTD_UpdateUserCode() {
        return CTD_UpdateUserCode;
    }

    public void setCTD_UpdateUserCode(String CTD_UpdateUserCode) {
        this.CTD_UpdateUserCode = CTD_UpdateUserCode;
    }

    public String getCTD_HosCode() {
        return CTD_HosCode;
    }

    public void setCTD_HosCode(String CTD_HosCode) {
        this.CTD_HosCode = CTD_HosCode;
    }

    public String getCTD_DepartmentGroup() {
        return CTD_DepartmentGroup;
    }

    public void setCTD_DepartmentGroup(String CTD_DepartmentGroup) {
        this.CTD_DepartmentGroup = CTD_DepartmentGroup;
    }

    public String getCTD_AdmType() {
        return CTD_AdmType;
    }

    public void setCTD_AdmType(String CTD_AdmType) {
        this.CTD_AdmType = CTD_AdmType;
    }

    public String getCTD_ParentCode() {
        return CTD_ParentCode;
    }

    public void setCTD_ParentCode(String CTD_ParentCode) {
        this.CTD_ParentCode = CTD_ParentCode;
    }

    public String getCTD_Status() {
        return CTD_Status;
    }

    public void setCTD_Status(String CTD_Status) {
        this.CTD_Status = CTD_Status;
    }
}
