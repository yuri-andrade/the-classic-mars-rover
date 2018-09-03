package br.pucrs.gcs;

/**
 *
 */
public class Rover {
    private String posFinal;
    private int finalCordinateX;
    private int finalCordinateY;
    private String direction;

    public Rover(String posInicial) {
        String[] initialInput = posInicial.split("\\s+");
        int initialCordinateX = Integer.parseInt(initialInput[0]);
        int initialCordinateY = Integer.parseInt(initialInput[1]);
        this.direction = initialInput[2];
        this.finalCordinateY = initialCordinateY;
        this.finalCordinateX = initialCordinateX;
    }

    public String getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(String posFinal) {
        this.posFinal = posFinal;
    }

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
                            finalCordinateY++;
                            break;
                        case "S":
                            finalCordinateY--;
                            break;
                        case "E":
                            finalCordinateX++;
                            break;
                        case "W":
                            finalCordinateX--;
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
        sb.append(finalCordinateX);
        sb.append(" ");
        sb.append(finalCordinateY);
        sb.append(" ");
        sb.append(direction);
        setPosFinal(sb.toString());
    }
}
