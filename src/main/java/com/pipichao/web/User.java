package com.pipichao.web;

import io.swagger.annotations.ApiModelProperty;

public class User {
    @ApiModelProperty
    private String id;
    @ApiModelProperty
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  this.id+":"+this.name;
    }
}
