package org.example.matb02cucumber.infrastructure.adapters.entities;

public enum TypeUser {
    USER(1),
    SELLER(2);

    private final Integer value;

    TypeUser(Integer value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
