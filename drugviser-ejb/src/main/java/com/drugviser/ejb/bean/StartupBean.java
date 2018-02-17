package com.drugviser.ejb.bean;

import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.apache.log4j.Logger;

/**
 * Application Startup Singleton Session Bean.
 *
 * @author caracciobreno
 */
@Startup
@Singleton
public class StartupBean {

    /**
     * Default Logger for this Bean.
     */
    private static final Logger LOGGER = Logger.getLogger(StartupBean.class);

    /**
     * Maintain the server up status.
     */
    private static AtomicBoolean INITIALIZED_SERVER_STATE = new AtomicBoolean();

    /**
     * Initializes everything up.
     */
    @PostConstruct
    void init() {
        if (INITIALIZED_SERVER_STATE.get()) {
            throw new RuntimeException("Server already started.");
        }

        INITIALIZED_SERVER_STATE.set(true);
        LOGGER.warn("Server started!");
    }
}
