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
    private String direction;

    public Rover(String posInicial) {
        String[] initialInput = posInicial.split("\\s+");
        int initialCoordinateX = Integer.parseInt(initialInput[0]);
        int initialCoordinateY = Integer.parseInt(initialInput[1]);
        this.direction = initialInput[2];
        this.finalCoordinateY = initialCoordinateY;
        this.finalCoordinateX = initialCoordinateX;
    }

    public String getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(String posFinal) {
        this.posFinal = posFinal;
    }

    /**
     * Método para locomover o Rover pelo plateau.
     *
     * @param comando String contendo comando de orientação e movimentação do Rover.
     * @return String contendo a posição e orientação final do Rover.
     */
    public String moveRover(String comando) {
        int index = 0;

        if (direction.equals(Compass.getInstance().getCompass()[0])) {
            direction = Compass.getInstance().getCompass()[0];
            index = 0;
        } else if (direction.equals(Compass.getInstance().getCompass()[1])) {
            direction = Compass.getInstance().getCompass()[1];
            index = 1;
        } else if (direction.equals(Compass.getInstance().getCompass()[2])) {
            direction = Compass.getInstance().getCompass()[2];
            index = 2;
        } else if (direction.equals(Compass.getInstance().getCompass()[3])) {
            direction = Compass.getInstance().getCompass()[3];
            index = 3;
        }

        for (int i = 0; i < comando.length(); i++) {
            String aux = String.valueOf(comando.charAt(i));

            switch (aux) {
                case "L":
                    if (index == 0) {
                        direction = Compass.getInstance().getCompass()[3];
                        index = 3;
                    } else {
                        direction = Compass.getInstance().getCompass()[index - 1];
                        index--;
                    }
                    break;
                case "R":
                    if (index == 3) {
                        direction = Compass.getInstance().getCompass()[0];
                        index = 0;
                    } else {
                        direction = Compass.getInstance().getCompass()[index + 1];
                        index++;
                    }
                    break;
                case "M":
                    switch (direction) {
                        case "N":
                            finalCoordinateY++;
                            break;
                        case "S":
                            finalCoordinateY--;
                            break;
                        case "E":
                            finalCoordinateX++;
                            break;
                        case "W":
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
        StringBuilder sb = new StringBuilder();
        sb.append(finalCoordinateX);
        sb.append(" ");
        sb.append(finalCoordinateY);
        sb.append(" ");
        sb.append(direction);
        setPosFinal(sb.toString());
    }
}
