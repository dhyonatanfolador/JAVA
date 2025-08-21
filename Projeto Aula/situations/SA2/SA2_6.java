package situations.SA2;

import java.util.Scanner;

public class SA2_6 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			
			System.out.print("Digite o numero de horas: ");
			int horas = scanner.nextInt();
			int segundos = horas * 3600;
			System.out.println("\n" + horas + " horas sao " + segundos + " segundos");
		}
	}
}
