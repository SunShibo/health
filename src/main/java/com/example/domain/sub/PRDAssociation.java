package com.example.domain.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="PRDAssociationList")
@XmlAccessorType(XmlAccessType.FIELD)
public class PRDAssociation {
    @XmlElement(name = "PRDAssociationInfo")
    private List<PRDAssociationINFO> PRDAssociationInfo;

    public List<PRDAssociationINFO> getPRDAssociationInfo() {
        return PRDAssociationInfo;
    }

    public void setPRDAssociationInfo(List<PRDAssociationINFO> PRDAssociationInfo) {
        this.PRDAssociationInfo = PRDAssociationInfo;
    }
}
