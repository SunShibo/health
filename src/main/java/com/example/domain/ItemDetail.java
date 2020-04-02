package com.example.domain;

public class ItemDetail {

    private String itemDetailCode;//细项代码
    private String itemDetailDesc;//项目描述
    private String sequence;//顺序号
    private String required;//是否必填

    public String getItemDetailCode() {
        return itemDetailCode;
    }

    public void setItemDetailCode(String itemDetailCode) {
        this.itemDetailCode = itemDetailCode;
    }

    public String getItemDetailDesc() {
        return itemDetailDesc;
    }

    public void setItemDetailDesc(String itemDetailDesc) {
        this.itemDetailDesc = itemDetailDesc;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }
}
