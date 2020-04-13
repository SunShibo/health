package com.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetPatInfoRp")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetPatInfoRp {

    @XmlElement( name = "PatInfo" )
    private PatInfo PatInfo;   //相应对象

    public com.example.domain.PatInfo getPatInfo() {
        return PatInfo;
    }

    public void setPatInfo(com.example.domain.PatInfo patInfo) {
        PatInfo = patInfo;
    }
}
