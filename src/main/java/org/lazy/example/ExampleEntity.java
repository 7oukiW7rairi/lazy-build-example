package org.lazy.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExampleEntity {

    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
