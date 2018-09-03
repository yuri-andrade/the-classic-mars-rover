package br.pucrs.gcs;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int landedRovers = 0;
        String dimension;
        System.out.println("Insira as dimens�es: ");
        dimension = in.nextLine();
        while (landedRovers < 2) {
            System.out.println("Insira as cordenadas do rover: ");
            String inicial = getInitialCoordinates(in.nextLine());

            Rover rover = new Rover(inicial);

            System.out.println("Informe linha do comando de movimenta��o para rover: ");
            String mov = in.nextLine().toUpperCase();
            System.out.println(rover.moveRover(mov));

            landedRovers++;
        }
    }

    private static String getInitialCoordinates(String input) {
        String coordinates;
        Pattern pattern = Pattern.compile("([0-9] [0-9] [nesw])", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        coordinates = matcher.matches() ? matcher.group(1) : null;
        if (Objects.nonNull(coordinates)) {
            return coordinates.toUpperCase();
        } else {
            System.out.println("Informe um valor valido: ");
            return getInitialCoordinates(in.nextLine());
        }
    }

}
