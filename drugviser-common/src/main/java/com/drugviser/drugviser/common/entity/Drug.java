package com.drugviser.drugviser.common.entity;

import java.util.List;

/**
 * Drug entity.
 *
 * @author caracciobreno
 */
public class Drug {

    private long rxcui;

    private String shortName;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<DrugInteraction> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<DrugInteraction> interactions) {
        this.interactions = interactions;
    }
}
