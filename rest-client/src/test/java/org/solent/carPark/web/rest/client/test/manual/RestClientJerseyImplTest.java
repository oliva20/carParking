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
        assertNull(replyMessage.getMeter());

        // try to retreive entity with id 1
        ReplyMessage replyMessage2 = restClient.retrieveMeter(1);
        assertNotNull(replyMessage2);
        assertNotNull(replyMessage2.getMeter());

        Meter meter = replyMessage2.getMeter();
        System.out.println("Received Entity: " + meter);

    }

}
