package com.drugviser.drugviser.common.entity;

/**
 * Drug entity.
 *
 * @author caracciobreno
 */
public class Drug {

    private long rxcui;

    private String shortName;

    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
