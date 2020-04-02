package com.example.domain;

import java.util.List;

public class Project {
    private String sourceSystem;
    private String messageID;
    private String stationCode;//站点代码
    private String stationDesc;//站点描述
    private String itemCode;//大项代码
    private String itemDesc;//大项描述
    private List<ItemDetail> itemDetail;

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationDesc() {
        return stationDesc;
    }

    public void setStationDesc(String stationDesc) {
        this.stationDesc = stationDesc;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public List<ItemDetail> getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(List<ItemDetail> itemDetail) {
        this.itemDetail = itemDetail;
    }
}
