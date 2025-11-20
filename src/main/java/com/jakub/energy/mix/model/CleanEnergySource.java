package com.jakub.energy.mix.model;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CleanEnergySource {
    BIOMASS("biomass"),
    NUCLEAR("nuclear"),
    HYDRO("hydro"),
    WIND("wind"),
    SOLAR("solar");

    private final String fuelName;

    CleanEnergySource(String fuelName) {
        this.fuelName = fuelName;
    }

    public static boolean isClean(String key) {
        return Arrays.stream(values())
                .anyMatch(source -> source.fuelName.equalsIgnoreCase(key));

    }
}
