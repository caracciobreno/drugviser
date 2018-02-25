package com.drugviser.ejb.factory;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import com.drugviser.drugviser.business.proxy.NLMInteractionAPI;

/**
 * Factory for API proxy creation.
 *
 * @author Breno Caraccio
 */
public final class APIProxyFactory {

    // private constructor
    private APIProxyFactory() {
    }

    /**
     * Creates a proxy for the NLM Drug Interaction API.
     *
     * @return RestEasy Proxy instance of {@link NLMInteractionAPI}.
     */
    public static NLMInteractionAPI createNLMInteractionAPI() {
        return getProxy(NLMInteractionAPI.class, "https://rxnav.nlm.nih.gov/");
    }

    /**
     * Creates a Resteasy proxy for a given class and target URL.
     *
     * @param <T> Type of the proxy (usually an interface).
     *
     * @param clazz Class to be proxied.
     * @param target Target URL.
     *
     * @return Instance of {@code T}.
     */
    private static <T> T getProxy(Class<T> clazz, String target) {
        return new ResteasyClientBuilder()
                .build()
                .target(target)
                .proxy(clazz);
    }
}
