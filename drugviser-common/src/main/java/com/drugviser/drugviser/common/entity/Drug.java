package com.drugviser.drugviser.common.entity;

import java.util.List;

/**
 * Drug entity.
 *
 * @author caracciobreno
 */
public class Drug {

    private long rxcui;

    private String inputName;

    private String rxName;

    private boolean approximated;

    private final String disclaimer = (""
            + " It is not the intention of DrugViser to provide specific medical advice, but rather to provide users\n"
            + " with information to better understand their health and their medications. DrugViser doesn't fabricate any information, everything is\n"
            + " gathered from NLM API's.").trim();

    private List<DrugInteraction> interactions;

    /**
     * Defines the interactions between Drugs.
     */
    public class DrugInteraction {

        private long rxcui;

        private String name;

        private String severity;

        private String description;

        private String url;

        public long getRxcui() {
            return rxcui;
        }

        public void setRxcui(long rxcui) {
            this.rxcui = rxcui;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSeverity() {
            return severity;
        }

        public void setSeverity(String severity) {
            this.severity = severity;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public long getRxcui() {
        return rxcui;
    }

    public void setRxcui(long rxcui) {
        this.rxcui = rxcui;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getRxName() {
        return rxName;
    }

    public void setRxName(String rxName) {
        this.rxName = rxName;
    }

    public boolean isApproximated() {
        return approximated;
    }

    public void setApproximated(boolean approximated) {
        this.approximated = approximated;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public List<DrugInteraction> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<DrugInteraction> interactions) {
        this.interactions = interactions;
    }
}
