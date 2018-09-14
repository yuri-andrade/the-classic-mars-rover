package br.pucrs.gcs;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe Main do exercício de gcs.
 *
 * @author <a href="mailto:yuri.arend@acad.pucrs.br">yuri.arend</a>
 * @since 05/09/2018 22:27:00*
 */
public class App {
    private static Scanner in = new Scanner(System.in);
    private static int roverNumber;
    private static String dimension;
    private static String inicial;
    private static int landedRovers;
    private static String mov;

    /**
     * Método Main.
     */
    public static void main(String[] args) {
        System.out.println("Insira as dimensões: ");
        dimension = in.nextLine();
        System.out.println("Insira a quantidade de Rovers: ");
        roverNumber = in.nextInt();
        while (landedRovers < roverNumber) {
            in.nextLine();
            System.out.println("Insira as condenadas do rover: ");
            inicial = getInitialCoordinates(in.nextLine());
            Rover rover = new Rover(inicial);
            System.out.println("Informe linha do comando de movimentação para rover: ");
            mov = in.nextLine().toUpperCase();
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
