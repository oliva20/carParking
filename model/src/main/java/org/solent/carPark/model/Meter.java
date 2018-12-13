package org.solent.carPark.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.solent.carPark.model.ScheduleItem;

/**
 * Simple example entity with 3 fields
 *
 * @author cgallen
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Meter {
    
    
    List<ScheduleItem> schedules = new ArrayList();
    
    private Integer id;

    private String location = null;
    
    //setting setField variable so meter can get setField data from schedules item

    private String price = null;
    
    
    //grab a schedules by id

    public ScheduleItem getScheduleById(Integer id){
        ScheduleItem scheduleItem = new ScheduleItem();
                
        for(Integer i = 0; i > schedules.size(); i++){
            
             scheduleItem = schedules.get(i);
            
            if (Objects.equals(id, scheduleItem.getId())){
                System.out.println("No schedule was found under entered id");
                return scheduleItem;
            }
        }
        
        return scheduleItem; 
        
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getlocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
        
    }

    public void setPrice(String price) {
        this.price = price; 
    }

    @Override
    public String toString() {
        return "Entity{" + "id=" + id
                + ", Location=" + location
                + ", Price=" + price
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
        final Meter other = (Meter) obj;
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
