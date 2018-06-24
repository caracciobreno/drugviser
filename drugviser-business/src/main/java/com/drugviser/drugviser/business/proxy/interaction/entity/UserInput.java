package com.drugviser.drugviser.business.proxy.interaction.entity;

import java.util.List;

public class UserInput {

    private List<String> sources = null;
    private String rxcui;

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public String getRxcui() {
        return rxcui;
    }

    public void setRxcui(String rxcui) {
        this.rxcui = rxcui;
    }

}
