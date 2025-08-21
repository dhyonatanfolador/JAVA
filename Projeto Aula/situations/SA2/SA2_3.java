package situations.SA2;

import java.util.Scanner;

public class SA2_3 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			
			int[] valores = new int[20];
			int soma = 0;
			int maior = Integer.MIN_VALUE;
			int menor = Integer.MAX_VALUE;
			
			System.out.println("Digite 20 valores inteiros:");

			for(int i = 0; i < 20; ++i) {
			    valores[i] = scanner.nextInt();
			    soma += valores[i];
			    
			    if (valores[i] > maior) {
			        maior = valores[i];
			    }
			    if (valores[i] < menor) {
			        menor = valores[i];
			    }
			}

			double media = (double)soma / 20.0;
			System.out.println("Media: " + media);
			System.out.println("Maior: " + maior);
			System.out.println("Menor: " + menor);
		} 
	}
}
