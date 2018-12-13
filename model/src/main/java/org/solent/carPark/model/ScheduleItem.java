/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.carPark.model;

/**
 *
 * @author Andre
 */
public class ScheduleItem {

    String time;

    String price;

    Integer id;

    public String getTime() {
        return time;
    }

    public String getPrice() {
        return price;
    }
    
    public Integer getId(){
        return this.id;
    }
    
    public void setId(Integer id){
        this.id = id; 
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
