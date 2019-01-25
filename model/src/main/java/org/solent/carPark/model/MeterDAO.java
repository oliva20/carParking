package org.solent.carPark.model;

import java.util.List;

public interface MeterDAO {

    public Meter createMeter(Meter meter);

    public boolean deleteMeter(Integer id);

    public void deleteAllMeters();

    public Meter retrieveMeter(Integer id);

    public List<Meter> retrieveAllMeters();

    public List<Meter> retrieveMatchingMeters(Meter meterTemplate);

    public Meter updateMeter(Meter meter);
    
}
