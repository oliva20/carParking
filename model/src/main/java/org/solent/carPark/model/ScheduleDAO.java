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
public interface ScheduleDAO {
    public ScheduleItem createSchedule(ScheduleItem scheduleItem, Integer meterId);
    
    public void deleteSchedule(Integer id);
    
    public ScheduleItem updateSchedule(ScheduleItem scheduleItem);
}
