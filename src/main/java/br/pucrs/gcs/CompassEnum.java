package br.pucrs.gcs;

/**
 * Enum para representação de bússola para deslocamento do Rover.
 *
 * @author <a href="mailto:yuri.arend@acad.pucrs.br">yuri.arend</a>
 * @since 13/09/2018 01:26:00
 */
public enum CompassEnum {
    N(0, "North"),
    E(1, "East"),
    S(2, "South"),
    W(3, "West");

    private Integer code;
    private String label;

    CompassEnum(Integer code, String label) {
        this.code = code;
        this.label = label;
    }

    public Integer getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    /**
     * Método para retornar o Enum correspondente ao proximo valor.
     *
     * @return próximo CompassEnum da lista.
     */
    public CompassEnum next() {
        return values()[ordinal() + 1];
    }

    /**
     * Método para retornar o Enum correspondente ao valor anterior.
     *
     * @return CompassEnum anterior da lista.
     */
    public CompassEnum previous() {
        return values()[ordinal() - 1];
    }
}
