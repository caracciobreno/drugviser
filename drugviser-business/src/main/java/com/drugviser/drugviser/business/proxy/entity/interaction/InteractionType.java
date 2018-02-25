package com.drugviser.drugviser.business.proxy.entity.interaction;

import java.util.List;

public class InteractionType {

    private String comment;
    private MinConceptItem minConceptItem;
    private List<InteractionPair> interactionPair = null;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public MinConceptItem getMinConceptItem() {
        return minConceptItem;
    }

    public void setMinConceptItem(MinConceptItem minConceptItem) {
        this.minConceptItem = minConceptItem;
    }

    public List<InteractionPair> getInteractionPair() {
        return interactionPair;
    }

    public void setInteractionPair(List<InteractionPair> interactionPair) {
        this.interactionPair = interactionPair;
    }

}
