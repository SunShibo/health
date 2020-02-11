package com.example.domain;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Header")
@XmlAccessorType(XmlAccessType.FIELD)
public class Header {
    @XmlElement(name = "SourceSystem")
    private String SourceSystem;//消息来源
    @XmlElement(name = "MessageID")
    private String MessageID;//消息Id

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
}
