package br.pucrs.gcs;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int landedRovers = 0;
		String coordenadas ="";
		System.out.println("Insira as dimens�es: ");
		coordenadas = in.nextLine();
		while (landedRovers<2) {
			System.out.println("Insira as cordenadas do rover: ");
			String inicial = in.nextLine().toUpperCase();
			Rover rover = new Rover(inicial);
			System.out.println("Informe linha do comando de movimenta��o para rover: ");
			String mov = in.nextLine().toUpperCase();
			System.out.println(rover.moveRover(mov));
			landedRovers++;
		}
	}
}
