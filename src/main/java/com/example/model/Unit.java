package com.example.model;

public enum Unit {
    GRAMS("г"),
    MILLILITERS("мл"),
    PIECES("шт");
    
    private final String shortName;
    
    Unit(String shortName) {
        this.shortName = shortName;
    }
    
    public String getShortName() {
        return shortName;
    }
}
