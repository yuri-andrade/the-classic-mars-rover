package br.pucrs.gcs;

import java.util.Objects;

public class Compass {
    private static Compass instance = null;
    private String[] compass;

    public static synchronized Compass getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Compass();
        }
        return instance;

    }

    private Compass() {
        this.compass = new String[]{"N", "E", "S", "W"};
    }

    public String[] getCompass() {
        return compass;
    }
}
