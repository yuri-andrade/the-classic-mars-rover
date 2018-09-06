package br.pucrs.gcs;

import java.util.Objects;

/**
 * Singleton que implementa um Compass para orientação do {@link Rover}.
 *
 * @author <a href="mailto:yuri.arend@acad.pucrs.br">yuri.arend</a>
 * @since 05/09/2018 22:29:00
 */
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
