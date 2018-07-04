package com.drugviser.ejb.factory;

import com.drugviser.drugviser.business.proxy.interaction.NLMInteractionAPI;
import com.drugviser.drugviser.business.proxy.rxcui.NLMRxNormAPI;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

/**
 * Factory for API proxy creation.
 *
 * @apiNote An API proxy is basically an interface that describes the Path, the
 * params and the return for an external provided REST API. By using a proxied
 * API, you invoke the REST service using easy-to-read java calls.
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
     * Creates a proxy for the NLM RxNorm API.
     *
     * @return RestEasy Proxy instance of {@link NLMRxNormAPI}.
     */
    public static NLMRxNormAPI createNLMRxNormAPI() {
        return getProxy(NLMRxNormAPI.class, "https://rxnav.nlm.nih.gov/");
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
