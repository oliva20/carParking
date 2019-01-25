/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.carPark.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andre
 */


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class ScheduleItem {
    
    private String time;

    private String price;

    private Integer id;
    
    public void setTime(String time){
        this.time = time; 
    }
    
    public void setPrice(String price){
        this.price = price; 
    }
    
    public void setId(Integer id){
        this.id = id; 
    }
    
    public int getTimeInt(){
        Integer nTime = Integer.valueOf(time);
        return nTime;
    }
    
    public String getTime(){   
        return time;
    }
    
    public String getPrice(){
        return price; 
    }
    
    public Integer getId(){
        return id;
    }
    
 @Override
    public String toString() {
        return "Schedule{" + "id=" + id
                + ", Price=" + price
                + ", Time=" + time
                + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ScheduleItem other = (ScheduleItem) obj;
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
