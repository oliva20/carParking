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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andre
 */


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class ScheduleItem {

    public String time;

    public String price;

    public Integer id;
    
    public void setTime(String time){
        this.time = time; 
    }
    
    public void setPrice(String price){
        this.price = price; 
    }
    
    public void setId(Integer id){
        this.id = id; 
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
    
}
