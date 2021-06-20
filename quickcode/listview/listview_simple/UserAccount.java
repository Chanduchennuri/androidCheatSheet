package com.example.bareapp;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class UserAccount implements Serializable {
    private String name;
    private String type;
    private boolean active;

    public UserAccount(String name, String type, boolean active) {
        this.name = name;
        this.type = type;
        this.active = active;
    }

    public UserAccount(String name, String type) {
        this.name = name;
        this.type = type;
        this.active = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @NonNull
    @Override
    public String toString() {
        return  name + " (" + type + ')';
    }
}
