package com.drugviser.drugviser.business.proxy.entity.interaction;

import java.util.List;

public class InteractionJSON {

    private String nlmDisclaimer;
    private UserInput userInput;
    private List<InteractionTypeGroup> interactionTypeGroup = null;

    public String getNlmDisclaimer() {
        return nlmDisclaimer;
    }

    public void setNlmDisclaimer(String nlmDisclaimer) {
        this.nlmDisclaimer = nlmDisclaimer;
    }

    public UserInput getUserInput() {
        return userInput;
    }

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }

    public List<InteractionTypeGroup> getInteractionTypeGroup() {
        return interactionTypeGroup;
    }

    public void setInteractionTypeGroup(List<InteractionTypeGroup> interactionTypeGroup) {
        this.interactionTypeGroup = interactionTypeGroup;
    }

}
