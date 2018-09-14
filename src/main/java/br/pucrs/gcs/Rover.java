package br.pucrs.gcs;

/**
 * Classe de implementação de um Rover e sua locomoção pelo plateau.
 *
 * @author <a href="mailto:yuri.arend@acad.pucrs.br">yuri.arend</a>
 * @since 05/09/2018 22:31:00
 */
public class Rover {
    private String posFinal;
    private int finalCoordinateX;
    private int finalCoordinateY;
    private CompassEnum directionEnum;

    public Rover(final String posInicial) {
        String[] initialInput = posInicial.split("\\s+");
        int initialCoordinateX = Integer.parseInt(initialInput[0]);
        int initialCoordinateY = Integer.parseInt(initialInput[1]);
        this.directionEnum = CompassEnum.valueOf(initialInput[2]);
        this.finalCoordinateY = initialCoordinateY;
        this.finalCoordinateX = initialCoordinateX;
    }

    public String getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(final String posFinal) {
        this.posFinal = posFinal;
    }

    /**
     * Método para locomover o Rover pelo plateau.
     *
     * @param comando String contendo comando de orientação e movimentação do Rover.
     * @return String contendo a posição e orientação final do Rover.
     */
    public String moveRover(final String comando) {
        for (int i = 0; i < comando.length(); i++) {
            String aux = String.valueOf(comando.charAt(i));
            switch (aux) {

                case "L":
                    directionEnum = directionEnum.previous();
                    break;

                case "R":
                    directionEnum = directionEnum.next();
                    break;

                case "M":
                    switch (directionEnum.getLabel()) {
                        case "North":
                            finalCoordinateY++;
                            break;

                        case "South":
                            finalCoordinateY--;
                            break;

                        case "East":
                            finalCoordinateX++;
                            break;

                        case "West":
                            finalCoordinateX--;
                            break;
                    }
                    break;
            }
        }
        defineFinalPosition();
        return posFinal;
    }

    private void defineFinalPosition() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(finalCoordinateX)
                .append(" ").append(finalCoordinateY)
                .append(" ")
                .append(directionEnum.toString());
        setPosFinal(stringBuilder.toString());
    }
}
