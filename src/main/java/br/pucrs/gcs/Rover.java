package br.pucrs.gcs;

public class Rover {
    private String posInicial;
    private String posFinal;

    public String getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(String posFinal) {
        this.posFinal = posFinal;
    }

    public String getPosInicial() {
        return posInicial;
    }

    public Rover(String posInicial) {
        this.posInicial = posInicial;
    }

    public String moveRover(String comando) {
        int index = 0;
        String aux = "";
        String[] compass = new String[4];
        compass[0] = "N";
        compass[1] = "E";
        compass[2] = "S";
        compass[3] = "W";
        String[] coordinates = posInicial.split("\\s+");
        int iniCordX = Integer.parseInt(coordinates[0]);
        int iniCordY = Integer.parseInt(coordinates[1]);
        String direction = coordinates[2];
        if (direction.equals(compass[0])) {
            direction = compass[0];
            index = 0;
        } else if (direction.equals(compass[1])) {
            direction = compass[1];
            index = 1;
        } else if (direction.equals(compass[2])) {
            direction = compass[2];
            index = 2;
        } else if (direction.equals(compass[3])) {
            direction = compass[3];
            index = 3;
        }

        for (int i = 0; i < comando.length(); i++) {
            aux += comando.charAt(i);
            if (aux.contentEquals("L")) {
                if (index == 0) {
                    direction = compass[3];
                    index = 3;
                } else {
                    direction = compass[index - 1];
                    index--;
                }
            }
            if (aux.contentEquals("R")) {
                if (index == 3) {
                    direction = compass[0];
                    index = 0;
                } else {
                    direction = compass[index + 1];
                    index++;
                }
            }
            if (aux.contentEquals("M")) {

                if (direction.equals("N")) {
                    iniCordY++;
                }
                if (direction.equals("S")) {
                    iniCordY--;
                }
                if (direction.equals("E")) {
                    iniCordX++;
                }
                if (direction.equals("W")) {
                    iniCordX--;
                }

            }
            aux = "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(iniCordX);
        sb.append(" ");
        sb.append(iniCordY);
        sb.append(" ");
        sb.append(direction.toString());
        setPosFinal(sb.toString());
        return posFinal;
    }
}
