package com.example.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Body")
public class Body {
    @XmlElement(name = "PatientRegistryRt")
    private  Patient PatientRegistryRt;

    public Patient getPatientRegistryRt() {
        return PatientRegistryRt;
    }

    public void setPatientRegistryRt(Patient patientRegistryRt) {
        PatientRegistryRt = patientRegistryRt;
    }
}
