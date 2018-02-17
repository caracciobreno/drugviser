package com.drugviser.drugviser.common.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Drug entity.
 *
 * @author caracciobreno
 */
@XmlRootElement
public class Drug implements Serializable {

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
