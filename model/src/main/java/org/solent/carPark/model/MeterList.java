/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.carPark.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cgallen
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MeterList {

    // only used by persistance layer
    private Integer lastMeterId = null;

    @XmlElementWrapper(name = "meters")
    @XmlElement(name = "meter")
    private List<Meter> meters = new ArrayList<Meter>();

    public List<Meter> getMeters() {
        return meters;
    }

    public void setMeters(List<Meter> meters) {
        this.meters = meters;
    }
    
    
    public Integer getLastMeterId() {
        return lastMeterId;
    }

    public void setLastEntityId(Integer lastEntityId) {
        this.lastMeterId = lastEntityId;
    }

    @Override
    public String toString() {
        return "EntityList{" + "lastEntityId=" + lastMeterId + ", entities=" + meters + '}';
    }



}
