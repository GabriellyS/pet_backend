package com.sherlockin.petbackend.model.enums;

public enum RoleName {

    ROLE_ADMIN("ROLE_ADMIN");


    public static final String ADMIN = "ROLE_ADMIN";

    public final String label;

    RoleName(String label) {
        this.label = label;
    }
}