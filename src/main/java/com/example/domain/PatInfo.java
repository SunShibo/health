package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PatInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class PatInfo {

    @XmlElement( name = "PATPatientID" )
    private String  PATPatientID;   //病人id
    @XmlElement( name = "PATPatientName" )
    private String  PATPatientName;   //患者姓名
    @XmlElement( name = "PATSexCode" )
    private String  PATSexCode;   //患者性别代码
    @XmlElement( name = "PATSexDesc" )
    private String  PATSexDesc;   //患者性别描述
    @XmlElement( name = "PATDob" )
    private String  PATDob;   //患者出生日期
    @XmlElement( name = "PATTelephone" )
    private String  PATTelephone;   //患者联系电话
    @XmlElement( name = "PATDocumentNo" )
    private String  PATDocumentNo;   //患者病案号
    @XmlElement( name = "PATPatientAddress" )
    private String  PATPatientAddress;   //患者家庭住址
    @XmlElement( name = "PATIdTypeCode" )
    private String  PATIdTypeCode;   //患者证件类别（代码）
    @XmlElement( name = "PATIdTypeDesc" )
    private String  PATIdTypeDesc;   //患者证件类别（描述）
    @XmlElement( name = "PATIdentityNum" )
    private String  PATIdentityNum;   //患者证件号码
    @XmlElement( name = "InsureCardNo" )
    private String  InsureCardNo;   //医保卡号
    @XmlElement( name = "AccInfo" )
    private String  AccInfo;   //账户信息
    @XmlElement( name = "AccountBalance" )
    private String  AccountBalance;   //账户余额
    @XmlElement( name = "AccountID" )
    private String  AccountID;   //账户ID
    @XmlElement( name = "PATCardNum" )
    private String  PATCardNum;   //患者卡号
    @XmlElement( name = "YBFlag" )
    private String  YBFlag;   //医保标志
    @XmlElement( name = "PATTypeDesc" )
    private String  PATTypeDesc;   //病人类型描述
    @XmlElement( name = "PATType" )
    private String  PATType;   //病人类型代码


    public String getPATPatientID() {
        return PATPatientID;
    }

    public void setPATPatientID(String PATPatientID) {
        this.PATPatientID = PATPatientID;
    }

    public String getPATPatientName() {
        return PATPatientName;
    }

    public void setPATPatientName(String PATPatientName) {
        this.PATPatientName = PATPatientName;
    }

    public String getPATSexCode() {
        return PATSexCode;
    }

    public void setPATSexCode(String PATSexCode) {
        this.PATSexCode = PATSexCode;
    }

    public String getPATSexDesc() {
        return PATSexDesc;
    }

    public void setPATSexDesc(String PATSexDesc) {
        this.PATSexDesc = PATSexDesc;
    }

    public String getPATDob() {
        return PATDob;
    }

    public void setPATDob(String PATDob) {
        this.PATDob = PATDob;
    }

    public String getPATTelephone() {
        return PATTelephone;
    }

    public void setPATTelephone(String PATTelephone) {
        this.PATTelephone = PATTelephone;
    }

    public String getPATDocumentNo() {
        return PATDocumentNo;
    }

    public void setPATDocumentNo(String PATDocumentNo) {
        this.PATDocumentNo = PATDocumentNo;
    }

    public String getPATPatientAddress() {
        return PATPatientAddress;
    }

    public void setPATPatientAddress(String PATPatientAddress) {
        this.PATPatientAddress = PATPatientAddress;
    }

    public String getPATIdTypeCode() {
        return PATIdTypeCode;
    }

    public void setPATIdTypeCode(String PATIdTypeCode) {
        this.PATIdTypeCode = PATIdTypeCode;
    }

    public String getPATIdTypeDesc() {
        return PATIdTypeDesc;
    }

    public void setPATIdTypeDesc(String PATIdTypeDesc) {
        this.PATIdTypeDesc = PATIdTypeDesc;
    }

    public String getPATIdentityNum() {
        return PATIdentityNum;
    }

    public void setPATIdentityNum(String PATIdentityNum) {
        this.PATIdentityNum = PATIdentityNum;
    }

    public String getInsureCardNo() {
        return InsureCardNo;
    }

    public void setInsureCardNo(String insureCardNo) {
        InsureCardNo = insureCardNo;
    }

    public String getAccInfo() {
        return AccInfo;
    }

    public void setAccInfo(String accInfo) {
        AccInfo = accInfo;
    }

    public String getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        AccountBalance = accountBalance;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String accountID) {
        AccountID = accountID;
    }

    public String getPATCardNum() {
        return PATCardNum;
    }

    public void setPATCardNum(String PATCardNum) {
        this.PATCardNum = PATCardNum;
    }

    public String getYBFlag() {
        return YBFlag;
    }

    public void setYBFlag(String YBFlag) {
        this.YBFlag = YBFlag;
    }

    public String getPATTypeDesc() {
        return PATTypeDesc;
    }

    public void setPATTypeDesc(String PATTypeDesc) {
        this.PATTypeDesc = PATTypeDesc;
    }

    public String getPATType() {
        return PATType;
    }

    public void setPATType(String PATType) {
        this.PATType = PATType;
    }
}
