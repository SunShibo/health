package com.example.domain;

import java.util.Date;
import java.util.List;

public class Patients {

    /**
     * 患者主索引
     */
    private String PATPatientID;
    /**
     * 患者姓名
     */
    private String PATPatientName;
    /**
     * 患者出生日期
     */
    private Date PATDob;
    /**
     * 年龄
     */
    private String PATAge;

    /**
     * 患者性别代码
     */
    private String PATSexCode;
    /**
     * 患者性别代码
     */
    private String PATSexDesc;
    /**
     * 患者婚姻状况代码
     */
    private String PATMaritalStatusCode;
    /**
     * 患者婚姻状况描述
     */
    private String PATMaritalStatusDesc;
    /**
     * 患者民族代码
     */
    private String PATNationCode;


    private String PATNationDesc;
    /**
     * 患者国籍代码
     */
    private String PATCountryCode;
    /**
     * 患者国籍描述
     */
    private String PATCountryDesc;
    /**
     * 患者死亡日期
     */
    private Date PATDeceasedDate;
    /**
     * 患者死亡时间
     */
    private Date PATDeceasedTime;
    /**
     * 患者健康卡号
     */
    private String PATHealthCardID;
    /**
     * 患者母亲ID
     */
    private String PATMotherID;
    /**
     * 患者职业代码
     */
    private String PATOccupationCode;
    /**
     * 患者职业描述
     */
    private String PATOccupationDesc;
    /**
     * 患者工作单位名称
     */

    private String PATWorkPlaceName;
    /**
     * 患者工作单位电话号码
     */
    private String PATWorkPlaceTelNum;
    /**
     * 患者联系电话
     */
    private String PATTelephone;
    /**
     * 患者备注
     */
    private String PATRemarks;
    /**
     * 最后更新人编码
     */
    private String UpdateUserCode;
    /**
     * 最后更新人描述
     */
    private String UpdateUserDesc;
    /**
     * 最后更新日期
     */
    private Date UpdateDate;
    /**
     * 最后更新时间
     */

    private Date UpdateTime;
    /**
     * 业务域代码
     */
    private String BusinessFieldCode;
    /**
     * 医院编码
     */
    private String HospitalCode;
    /**
     * 患者病案号
     */
    private String PATDocumentNo;
    /**
     * 患者地址
     */
    private List<Address> Address;


    /**
     * 患者身份证
     */
    private List<Certificatess> Certificate;
    /**
     * 患者联系人
     */
    private List<PATRelation> PATRelation;


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

    public Date getPATDob() {
        return PATDob;
    }

    public void setPATDob(Date PATDob) {
        this.PATDob = PATDob;
    }

    public String getPATAge() {
        return PATAge;
    }

    public void setPATAge(String PATAge) {
        this.PATAge = PATAge;
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

    public String getPATMaritalStatusCode() {
        return PATMaritalStatusCode;
    }

    public void setPATMaritalStatusCode(String PATMaritalStatusCode) {
        this.PATMaritalStatusCode = PATMaritalStatusCode;
    }

    public String getPATMaritalStatusDesc() {
        return PATMaritalStatusDesc;
    }

    public void setPATMaritalStatusDesc(String PATMaritalStatusDesc) {
        this.PATMaritalStatusDesc = PATMaritalStatusDesc;
    }

    public String getPATNationCode() {
        return PATNationCode;
    }

    public void setPATNationCode(String PATNationCode) {
        this.PATNationCode = PATNationCode;
    }

    public String getPATNationDesc() {
        return PATNationDesc;
    }

    public void setPATNationDesc(String PATNationDesc) {
        this.PATNationDesc = PATNationDesc;
    }

    public String getPATCountryCode() {
        return PATCountryCode;
    }

    public void setPATCountryCode(String PATCountryCode) {
        this.PATCountryCode = PATCountryCode;
    }

    public String getPATCountryDesc() {
        return PATCountryDesc;
    }

    public void setPATCountryDesc(String PATCountryDesc) {
        this.PATCountryDesc = PATCountryDesc;
    }

    public Date getPATDeceasedDate() {
        return PATDeceasedDate;
    }

    public void setPATDeceasedDate(Date PATDeceasedDate) {
        this.PATDeceasedDate = PATDeceasedDate;
    }

    public Date getPATDeceasedTime() {
        return PATDeceasedTime;
    }

    public void setPATDeceasedTime(Date PATDeceasedTime) {
        this.PATDeceasedTime = PATDeceasedTime;
    }

    public String getPATHealthCardID() {
        return PATHealthCardID;
    }

    public void setPATHealthCardID(String PATHealthCardID) {
        this.PATHealthCardID = PATHealthCardID;
    }

    public String getPATMotherID() {
        return PATMotherID;
    }

    public void setPATMotherID(String PATMotherID) {
        this.PATMotherID = PATMotherID;
    }

    public String getPATOccupationCode() {
        return PATOccupationCode;
    }

    public void setPATOccupationCode(String PATOccupationCode) {
        this.PATOccupationCode = PATOccupationCode;
    }

    public String getPATOccupationDesc() {
        return PATOccupationDesc;
    }

    public void setPATOccupationDesc(String PATOccupationDesc) {
        this.PATOccupationDesc = PATOccupationDesc;
    }

    public String getPATWorkPlaceName() {
        return PATWorkPlaceName;
    }

    public void setPATWorkPlaceName(String PATWorkPlaceName) {
        this.PATWorkPlaceName = PATWorkPlaceName;
    }

    public String getPATWorkPlaceTelNum() {
        return PATWorkPlaceTelNum;
    }

    public void setPATWorkPlaceTelNum(String PATWorkPlaceTelNum) {
        this.PATWorkPlaceTelNum = PATWorkPlaceTelNum;
    }

    public String getPATTelephone() {
        return PATTelephone;
    }

    public void setPATTelephone(String PATTelephone) {
        this.PATTelephone = PATTelephone;
    }

    public String getPATRemarks() {
        return PATRemarks;
    }

    public void setPATRemarks(String PATRemarks) {
        this.PATRemarks = PATRemarks;
    }

    public String getUpdateUserCode() {
        return UpdateUserCode;
    }

    public void setUpdateUserCode(String updateUserCode) {
        UpdateUserCode = updateUserCode;
    }

    public String getUpdateUserDesc() {
        return UpdateUserDesc;
    }

    public void setUpdateUserDesc(String updateUserDesc) {
        UpdateUserDesc = updateUserDesc;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        UpdateDate = updateDate;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }

    public String getBusinessFieldCode() {
        return BusinessFieldCode;
    }

    public void setBusinessFieldCode(String businessFieldCode) {
        BusinessFieldCode = businessFieldCode;
    }

    public String getHospitalCode() {
        return HospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        HospitalCode = hospitalCode;
    }

    public String getPATDocumentNo() {
        return PATDocumentNo;
    }

    public void setPATDocumentNo(String PATDocumentNo) {
        this.PATDocumentNo = PATDocumentNo;
    }

    public List<com.example.domain.Address> getAddress() {
        return Address;
    }

    public void setAddress(List<com.example.domain.Address> address) {
        Address = address;
    }

    public List<Certificatess> getCertificate() {
        return Certificate;
    }

    public void setCertificate(List<Certificatess> certificate) {
        Certificate = certificate;
    }

    public List<com.example.domain.PATRelation> getPATRelation() {
        return PATRelation;
    }

    public void setPATRelation(List<com.example.domain.PATRelation> PATRelation) {
        this.PATRelation = PATRelation;
    }
}
