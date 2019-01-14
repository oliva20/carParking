/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.carPark.web.rest.client.test.manual;

import java.util.List;
import javax.ws.rs.core.MediaType;
import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.carPark.model.Meter;
import org.solent.carPark.model.ReplyMessage;
import org.solent.carPark.web.rest.client.RestClientJerseyImpl;

/**
 *
 * @author cgallen
 */
public class RestClientJerseyImplTest {

    String baseUrl = "http://localhost:8680/";

    MediaType mediaType = MediaType.APPLICATION_XML_TYPE;

    @Test
    public void restClientRetreiveTest() {

        RestClientJerseyImpl restClient = new RestClientJerseyImpl(baseUrl, mediaType);
        
        // try to retreive an unknown entity
        ReplyMessage replyMessage = restClient.retrieveMeter(Integer.SIZE);
        assertNotNull(replyMessage);
        assertTrue(replyMessage.getMeterList().getMeters().isEmpty());

        // try to retreive entity with id 1
        ReplyMessage replyMessage2 = restClient.retrieveMeter(1);
        assertNotNull(replyMessage2);
        assertEquals(1, replyMessage2.getMeterList().getMeters().size());

        Meter meter = replyMessage2.getMeterList().getMeters().get(0);
        System.out.println("Received Entity: " + meter);

    }

    @Test
    public void restClientRetreiveTemplateTest() {

        RestClientJerseyImpl restClient = new RestClientJerseyImpl(baseUrl, mediaType);

        Meter entityTempate = new Meter();
        entityTempate.setLocation("abcd");

        // try to retreive an unknown meter
        ReplyMessage replyMessage = restClient.retrieveMatchingMeters(entityTempate);
        assertNotNull(replyMessage);

        List<Meter> entityList =  replyMessage.getMeterList().getMeters();
        System.out.println("Received "
                + entityList.size()
                + " Entities");
        
       for(Meter e: entityList){
           System.out.println("   "+ e);
       }
        
    }
}
