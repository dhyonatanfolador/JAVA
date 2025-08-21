package situations.SA2;

import java.util.Scanner;

public class SA2_2 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			
			int[] valores = new int[4];
			int soma = 0;

			for(int i = 0; i < 4; ++i) {
			    System.out.print("Digite um valor: ");
			    valores[i] = scanner.nextInt();
			    soma += valores[i];
			}
			
			double media = (double)soma / 4.0;
			System.out.println("Media: " + media);
			System.out.println(media > 1.0 ? "Positivo" : "Negativo");
		}
	}
}
