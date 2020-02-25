package com.example.domain;

public class Certificatess {
    /**
     * 患者证件号码
     */
    private String PATIdentityNum;
    /**
     * 患者证件类别代码
     */
    private String PATIdTypeCode;
    /**
     * 患者证件类别描述
     */
    private String PATIdTypeDesc;

    public String getPATIdentityNum() {
        return PATIdentityNum;
    }

    public void setPATIdentityNum(String PATIdentityNum) {
        this.PATIdentityNum = PATIdentityNum;
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


}
