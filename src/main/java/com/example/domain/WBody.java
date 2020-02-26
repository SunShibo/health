package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Body")
@XmlAccessorType(XmlAccessType.FIELD)
public class WBody {

    @XmlElement(name = "ResultCode")
    private String ResultCode; //响应编码  0:成功  -1:失败
    @XmlElement(name = "ResultContent")
    private String ResultContent; // 返回响应结果

    @XmlElement(name = "MedExamSummaryRp")
    private MedExamSummaryRp MedExamSummaryRp;//体检建议
    @XmlElement(name = "MedExamRp")
    private MedExamItemRp MedExamItemRp;//报告项目明细

    public com.example.domain.MedExamItemRp getMedExamItemRp() {
        return MedExamItemRp;
    }

    public void setMedExamItemRp(com.example.domain.MedExamItemRp medExamItemRp) {
        MedExamItemRp = medExamItemRp;
    }

    public com.example.domain.MedExamSummaryRp getMedExamSummaryRp() {
        return MedExamSummaryRp;
    }

    public void setMedExamSummaryRp(com.example.domain.MedExamSummaryRp medExamSummaryRp) {
        MedExamSummaryRp = medExamSummaryRp;
    }

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String resultCode) {
        ResultCode = resultCode;
    }

    public String getResultContent() {
        return ResultContent;
    }

    public void setResultContent(String resultContent) {
        ResultContent = resultContent;
    }
}
