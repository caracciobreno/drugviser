package com.drugviser.drugviser.war.cfg;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * Resource definition's class.
 *
 * @author caracciobreno
 */
@javax.ws.rs.ApplicationPath("services")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
    }
}
