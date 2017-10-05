package com.drugviser.drugviser.entity.persistent;

import com.drugviser.drugviser.entity.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Medicine entity.
 *
 * @author caracciobreno
 */
@Entity
@XmlRootElement
public class Medicine extends AbstractEntity {

    @Id
    private long id;

    /**
     * Get the value of id.
     *
     * @return the value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Set the value of id.
     *
     * @param id new value of id
     */
    public void setId(long id) {
        this.id = id;
    }
}
