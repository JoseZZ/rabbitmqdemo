package com.rabbitmq;

import java.io.Serializable;

/**
 * Created by Jose Gonzalez on 23/11/2018.
 */
public class SimpleMessage implements Serializable{

    private String name;
    private String description;

    public SimpleMessage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
