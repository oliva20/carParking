/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.carPark.service;

import java.util.List;
import org.solent.carPark.model.Meter;
import org.solent.carPark.model.MeterDAO;
import org.solent.carPark.model.ServiceFacade;

/**
 *
 * @author cgallen
 */
public class ServiceFacadeImpl implements ServiceFacade {
    
    MeterDAO meterDAO = null;

    public void setMeterDAO(MeterDAO meterDAO) {
        this.meterDAO = meterDAO; 
    }

    @Override
    public void deleteAllMeters() {
       meterDAO.deleteAllMeters();
    }

    @Override
    public Meter createMeter(Meter meter) {
        return meterDAO.createMeter(meter);
    }

    @Override
    public boolean deleteMeter(Integer id) {
        return meterDAO.deleteMeter(id);
    }

    @Override
    public Meter retrieveMeter(Integer id) {
        return meterDAO.retrieveMeter(id);
    }

    @Override
    public List<Meter> retrieveAllMeters() {
        return meterDAO.retrieveAllMeters();
    }

    @Override
    public List<Meter> retrieveMatchingMeters(Meter meterTemplate) {
        return meterDAO.retrieveMatchingMeters(meterTemplate);
    }

    @Override
    public Meter updateMeter(Meter meter) {
        return meterDAO.updateMeter(meter);
    }
    
}
