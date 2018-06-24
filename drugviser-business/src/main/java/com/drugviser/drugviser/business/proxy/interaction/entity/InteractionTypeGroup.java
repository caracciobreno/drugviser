package com.drugviser.drugviser.business.proxy.interaction.entity;

import java.util.List;

public class InteractionTypeGroup {

    private String sourceDisclaimer;
    private String sourceName;
    private List<InteractionType> interactionType = null;

    public String getSourceDisclaimer() {
        return sourceDisclaimer;
    }

    public void setSourceDisclaimer(String sourceDisclaimer) {
        this.sourceDisclaimer = sourceDisclaimer;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public List<InteractionType> getInteractionType() {
        return interactionType;
    }

    public void setInteractionType(List<InteractionType> interactionType) {
        this.interactionType = interactionType;
    }

}
