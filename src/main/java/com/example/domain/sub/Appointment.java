package com.example.domain.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CreateAppointmentInfoRp")
@XmlAccessorType(XmlAccessType.FIELD)
public class Appointment {
    @XmlElement(name = "AppointmentNumber")
    private String AppointmentNumber;


    public String getAppointmentNumber() {
        return AppointmentNumber;
    }

    public void setAppointmentNumber(String appointmentNumber) {
        AppointmentNumber = appointmentNumber;
    }

}
