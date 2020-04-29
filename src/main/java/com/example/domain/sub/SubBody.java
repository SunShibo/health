package com.example.domain.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Body")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubBody {
    @XmlElement(name = "ResultCode")
    private String ResultCode;
    @XmlElement(name = "ResultContent")
    private String ResultContent;
    @XmlElement(name = "CreateAppointmentInfoRp")
    private Appointment CreateAppointmentInfoRp;


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

    public Appointment getCreateAppointmentInfoRp() {
        return CreateAppointmentInfoRp;
    }

    public void setCreateAppointmentInfoRp(Appointment createAppointmentInfoRp) {
        CreateAppointmentInfoRp = createAppointmentInfoRp;
    }



}
