/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.carPark.service;

import org.solent.carPark.dao.jaxbimpl.MeterDAOJaxbImpl;
import org.solent.carPark.model.MeterDAO;
import org.solent.carPark.model.ServiceFacade;
import org.solent.carPark.model.ServiceFactory;

/**
 *
 * @author cgallen
 */
public class ServiceFactoryImpl implements ServiceFactory {

    ServiceFacade serviceFacade = null;

    String dataFileUri = null;

    public ServiceFactoryImpl(String dataFileUri) {
        if (dataFileUri == null) {
            throw new IllegalArgumentException("dataFileUri must not be null");
        }
        
        MeterDAO meterDao = new MeterDAOJaxbImpl(dataFileUri);
        ServiceFacadeImpl serviceFacadeImpl = new ServiceFacadeImpl();
        serviceFacadeImpl.setMeterDAO(meterDao);
        serviceFacade = serviceFacadeImpl;
    }

    @Override
    public ServiceFacade getServiceFacade() {
        return serviceFacade;
    }

}
