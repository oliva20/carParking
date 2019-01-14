/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.carPark.dao.jaxbimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.solent.carPark.model.Meter;
import org.solent.carPark.model.MeterDAO;
import org.solent.carPark.model.ScheduleDAO;
import org.solent.carPark.model.ScheduleItem;

/**
 *
 * @author Andre
 */
public class ScheduleDAOJaxbImpl implements ScheduleDAO {
    private static final Logger LOG = LoggerFactory.getLogger(ScheduleDAOJaxbImpl.class);
    MeterDAO meterDao; 
    
    @Override
    public ScheduleItem createSchedule(ScheduleItem scheduleItem, Integer meterId){
        if (scheduleItem == null) {
            throw new IllegalArgumentException("Schedule cannot be null");
        }
        
        //get desired meter by id
        Meter meter = meterDao.retrieveMeter(meterId);
        meter.addSchedule(scheduleItem);
        
       return scheduleItem; 
    }
    
    @Override
    public void deleteSchedule(Integer id){
    }
    
    @Override
    public ScheduleItem updateSchedule(ScheduleItem scheduleItem){
        return null;
    }
}
