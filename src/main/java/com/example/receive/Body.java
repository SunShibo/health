package com.example.receive;

import javax.xml.bind.annotation.*;

/**
 * Created by wang bin
 */
@XmlRootElement(name="Body")
@XmlAccessorType(XmlAccessType.NONE)
public class Body {

    @XmlElement(name = "HMSMessageRt")
    private Doctor MSMessageRt;

    public Doctor getMSMessageRt() {
        return MSMessageRt;
    }

    public void setMSMessageRt(Doctor MSMessageRt) {
        this.MSMessageRt = MSMessageRt;
    }
}
