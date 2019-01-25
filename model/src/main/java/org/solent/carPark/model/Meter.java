package org.solent.carPark.model;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.solent.carPark.model.ScheduleItem;

/**
 *
 * @author abrasil
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Meter {

    private List<ScheduleItem> schedules = new ArrayList();

    private Integer lastScheduleId = 0;

    private Integer id;

    private String location = null;

    //setting setField variable so meter can get setField data from schedules item
    private String price = null;

    public String debugMessage = null;

    Calendar time = Calendar.getInstance();

    int hour = time.get(Calendar.HOUR);

    String stringHour = Integer.toString(hour);

    public String price1;

    public void setPrice1() {
        for (int i = 0; i < schedules.size(); i++) {
            ScheduleItem schedule = schedules.get(i);
            //checking if local hour equals schedule hour
            if (stringHour.equals(schedule.getTime())) {
                this.price1 = schedule.getPrice();
            }
        }
    }

    public String getPrice1() {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {

        this.price = price;

    }

    // Retrieve all schedules
    public List<ScheduleItem> getAllSchedules() {
        return schedules;
    }

    // function adds scheduleItem's to meter list
    public void addSchedule(ScheduleItem schedule) {
        lastScheduleId = lastScheduleId + 1;
        
        schedule.setId(lastScheduleId);

        List<ScheduleItem> newschedules = new ArrayList<ScheduleItem>(schedules);
        schedules.clear();
        
        if (newschedules.isEmpty()) {
            schedules.add(schedule);
        } else {
            for (ScheduleItem item : newschedules) {
                schedules.add(item);
                if (schedule.getTimeInt() > item.getTimeInt()) {
                    schedules.add(schedule);
                }; 
            }
        }
    }

    public ScheduleItem updateSchedule(ScheduleItem schedule) {

        for (Iterator<ScheduleItem> it = getAllSchedules().iterator(); it.hasNext();) {
            ScheduleItem sc = it.next();

            //won't update schedule if fields are null
            if (schedule.getId().equals(sc.getId())) {

                //sc.setPrice(null);
                //sc.setTime(null);
                if (schedule.getPrice() != null) {
                    sc.setPrice(schedule.getPrice());
                }

                if (schedule.getTime() != null) {
                    sc.setTime(schedule.getTime());
                }
            }
        }

        return schedule;
    }

    public boolean deleteSchedule(Integer id) {

        Iterator<ScheduleItem> it = getAllSchedules().iterator();

        while (it.hasNext()) {
            ScheduleItem en = it.next();
            if (id.equals(en.getId())) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public ScheduleItem getScheduleById(Integer id) {
        ScheduleItem schedule = null;
        for (ScheduleItem sc : getAllSchedules()) {
            if (id.equals(sc.getId())) {
                schedule = sc;
                break;
            }
        }
        return schedule;
    }

    public Double calculatePrice(Date startTime, Integer hours)  {
        
        
        
        return new Double(0);
    }
    
    @Override
    public String toString() {
        return "Meter{" + "id=" + id
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
