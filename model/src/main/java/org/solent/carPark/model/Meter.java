package org.solent.carPark.model;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.solent.carPark.model.ScheduleItem;

/**
 * Simple example entity with 3 fields
 *
 * @author abrasil
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Meter {
    
    List<ScheduleItem> schedules = new ArrayList();

    private Integer id;

    private String location = null;
    
    //setting setField variable so meter can get setField data from schedules item

    private String price = null;
    
    public String debugMessage = null; 
    
    Calendar time = Calendar.getInstance();
    
    int hour = time.get(Calendar.HOUR);
    
    String stringHour = Integer.toString(hour);
    
    public String price1; 
    
    public void setPrice1(){
        for (int i = 0; i < schedules.size(); i++) {
            ScheduleItem schedule = schedules.get(i);
            //checking if local hour equals schedule hour
            if (stringHour.equals(schedule.getTime())) {
                this.price1 = schedule.getPrice();
            }
        }
    }
    
    public String getPrice1(){
        return price1; 
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice(){
        return price;
    }
    

    public void setPrice(String price) {
        
        this.price = price;
    
    }
    
    // function adds scheduleItem's to meter list
    public String addSchedule(ScheduleItem schedule){
        //adding schedule to meter
        schedules.add(schedule);
        return "Schedule added to meter";
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