package org.solent.carPark.model;

public interface RestInterface {

    public ReplyMessage retrieveMatchingMeters(Meter entityTemplate);
    
    public ReplyMessage retrieveMeter(Integer id);
    
}
