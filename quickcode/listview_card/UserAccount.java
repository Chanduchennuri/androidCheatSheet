package com.example.bare;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class UserAccount implements Serializable {
    private String name;
    private String type;
    private boolean active;
    private int avatarResId;

    public UserAccount(String name, String type, int avatarResId, boolean active) {
        this.name = name;
        this.type = type;
        this.active = active;
        this.avatarResId = avatarResId;
    }

    public UserAccount(String name, String type, int avatarResId) {
        this(name, type, avatarResId, false);
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

    public int getAvatarResId() {
        return avatarResId;
    }

    public void setAvatarResId(int avatarResId) {
        this.avatarResId = avatarResId;
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
