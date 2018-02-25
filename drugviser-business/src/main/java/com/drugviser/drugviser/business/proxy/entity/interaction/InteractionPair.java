package com.drugviser.drugviser.business.proxy.entity.interaction;

import java.util.List;

public class InteractionPair {

    private List<InteractionConcept> interactionConcept = null;
    private String severity;
    private String description;

    public List<InteractionConcept> getInteractionConcept() {
        return interactionConcept;
    }

    public void setInteractionConcept(List<InteractionConcept> interactionConcept) {
        this.interactionConcept = interactionConcept;
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

}
