/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.carPark.dao.jaxbimpl.test;

import java.io.File;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.solent.carPark.dao.jaxbimpl.MeterDAOJaxbImpl;
import org.solent.carPark.model.Meter;
import org.solent.carPark.model.MeterDAO;
import org.solent.carPark.model.ScheduleItem;

/**
 * tests for meterDao.createMeter(entity) entityDao.deleteEntity(Id) entityDao.retrieveAllEntities() entityDao.retrieveEntity(Id)
 * entityDao.retrieveMatchingEntites(entityTempate) entityDao.updateEntity(entity)
 *
 * @author cgallen
 */
public class MeterDAOJaxbImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(MeterDAOJaxbImplTest.class);

    public final String TEST_DATA_FILE_LOCATION = "target/testDaofile.xml";

    @Test
    public void testDestinationsDAOJaxb() {

        // delete test file at start of test
        File file = new File(TEST_DATA_FILE_LOCATION);
        file.delete();
        assertFalse(file.exists());

        // create dao
        MeterDAO meterDao = new MeterDAOJaxbImpl(TEST_DATA_FILE_LOCATION);

        // check that new file created
        assertTrue(file.exists());

        // check there are no meters
        assertTrue(meterDao.retrieveAllMeters().isEmpty());

        // add a 3 meters
        int ENTITY_NUMBER = 4;
        for (int meterId = 0; meterId < ENTITY_NUMBER; meterId++) {
            Meter meter = new Meter();
          
            meter.setLocation("Location" + meterId);
            meter.setPrice("Price" + meterId); 

            LOG.debug("adding meter:" + meter);
            
            Meter e = meterDao.createMeter(meter);
            assertNotNull(e);
        }

        // check 3 entities added
        assertTrue(ENTITY_NUMBER == meterDao.retrieveAllMeters().size());

        // check return false for delete unknown meter
        assertFalse(meterDao.deleteMeter(Integer.SIZE));

        // find an meter to delete
        List<Meter> elist = meterDao.retrieveAllMeters();
        Integer idToDelete = elist.get(1).getId();
        LOG.debug("deleting  entity:" + idToDelete);

        // check found and deleted
        assertTrue(meterDao.deleteMeter(idToDelete));

        // check no longer found after deletion
        assertNull(meterDao.retrieveMeter(idToDelete));

        // check entities size decremeted
        List<Meter> elist2 = meterDao.retrieveAllMeters();
        assertTrue(ENTITY_NUMBER - 1 == elist2.size());

        // update entity
        Meter meterToUpdate = elist2.get(1);
        LOG.debug("updating meter: " + meterToUpdate);

        // add 2 new propeties for meter
        meterToUpdate.setLocation("location_update");
        meterToUpdate.setPrice("price_update");
        LOG.debug("update meter: " + meterToUpdate);

        Meter updatedMeter = meterDao.updateMeter(meterToUpdate);
        LOG.debug("updated meter: " + updatedMeter);
        assertNotNull(updatedMeter);

        // check meter updated
        Meter retrievedMeter = meterDao.retrieveMeter(updatedMeter.getId());
        LOG.debug("retreived meter: " + retrievedMeter);
        assertEquals(meterToUpdate.getLocation(), retrievedMeter.getLocation());
        assertEquals(meterToUpdate.getLocation(), retrievedMeter.getLocation());

        // test retrieve matching meters
        List<Meter> meterList = meterDao.retrieveAllMeters();
        Meter searchfor = meterList.get(2);
        LOG.debug("searching for: " + searchfor);
        
        Meter template = new Meter();
        template.setPrice(searchfor.getPrice());
        LOG.debug("using template : " + template);
   
        List<Meter> retrievedList = meterDao.retrieveMatchingMeters(template);

        assertEquals(1, retrievedList.size());

        LOG.debug("found : " + retrievedList.get(0));
        assertEquals(searchfor, retrievedList.get(0));
        
    }

}
