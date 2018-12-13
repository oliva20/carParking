/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.carPark.service.test;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.carPark.model.Meter;
import org.solent.carPark.model.ServiceFacade;
import org.solent.carPark.model.ServiceFactory;
import org.solent.carPark.service.ServiceFactoryImpl;

/**
 *
 * @author cgallen
 */
public class ServiceFacadeImplTest {

    public static final String TEST_DATA_FILE = "./target/testfile.xml";

    // Only some basic tests as most tests already done in EntityDAO tests
    @Test
    public void simpleServiceFacadeTest() {

        // use service factory to get access to service
        ServiceFactory serviceFactory = new ServiceFactoryImpl(TEST_DATA_FILE);
        assertNotNull(serviceFactory);

        ServiceFacade serviceFacade = serviceFactory.getServiceFacade();
        assertNotNull(serviceFacade);
        
        // clear file before anything else
        serviceFacade.deleteAllMeters();

        Meter meter = new Meter();
        meter.setLocation("testFieldA");

        serviceFacade.createMeter(meter);
        List<Meter> retrievedEntities = serviceFacade.retrieveMatchingMeters(meter);

        assertEquals(1, retrievedEntities.size());
    }
}
