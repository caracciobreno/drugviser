package com.drugviser.drugviser.business.proxy.rxcui.entity;

import java.util.List;

public class IdGroup {

    private String name;
    private List<String> rxnormId = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRxnormId() {
        return rxnormId;
    }

    public void setRxnormId(List<String> rxnormId) {
        this.rxnormId = rxnormId;
    }
}
