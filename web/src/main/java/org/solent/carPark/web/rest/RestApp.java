package org.solent.carPark.web.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class RestApp extends ResourceConfig {

    public RestApp() {
        packages("org.solent.carPark.web.rest");
    }
}
