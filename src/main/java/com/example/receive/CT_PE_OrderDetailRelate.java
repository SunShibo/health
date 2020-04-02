package com.example.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CT_PE_OrderDetailRelate")
@XmlAccessorType(XmlAccessType.NONE)
public class CT_PE_OrderDetailRelate {

    private Long id;
    private String SourceSystem;
    private String MessageID;
    @XmlElement(name = "ODR_StationCode")
    private String ODR_StationCode;
    @XmlElement(name = "ODR_StationDesc")
    private String ODR_StationDesc;
    @XmlElement(name = "ODR_ItemCode")
    private String ODR_ItemCode;
    @XmlElement(name = "ODR_ItemDesc")
    private String ODR_ItemDesc;

    @XmlElement(name = "ItemDetailList")
    private ItemDetailList itemDetailList;


    public String getODR_StationCode() {
        return ODR_StationCode;
    }

    public void setODR_StationCode(String ODR_StationCode) {
        this.ODR_StationCode = ODR_StationCode;
    }

    public String getODR_StationDesc() {
        return ODR_StationDesc;
    }

    public void setODR_StationDesc(String ODR_StationDesc) {
        this.ODR_StationDesc = ODR_StationDesc;
    }

    public String getODR_ItemCode() {
        return ODR_ItemCode;
    }

    public void setODR_ItemCode(String ODR_ItemCode) {
        this.ODR_ItemCode = ODR_ItemCode;
    }

    public String getODR_ItemDesc() {
        return ODR_ItemDesc;
    }

    public void setODR_ItemDesc(String ODR_ItemDesc) {
        this.ODR_ItemDesc = ODR_ItemDesc;
    }

    public ItemDetailList getItemDetailList() {
        return itemDetailList;
    }

    public void setItemDetailList(ItemDetailList itemDetailList) {
        this.itemDetailList = itemDetailList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
