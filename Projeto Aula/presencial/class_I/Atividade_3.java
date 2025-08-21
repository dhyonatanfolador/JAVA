package presencial.class_I;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Atividade_3 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Integer> lista = new ArrayList<>(List.of(59, 28, 3, 65, 32));

            System.out.print("Digite o valor de X (0-4): ");
            int x = scanner.nextInt();

            System.out.print("Digite o valor de Y (0-4): ");
            int y = scanner.nextInt();

            if (x >= 0 && x < 5 && y >= 0 && y < 5) {
                int soma = lista.get(x) + lista.get(y);
                System.out.println("A soma dos valores nas posições X e Y é: " + soma);
            } else {
                System.out.println("Posições inválidas. X e Y devem estar entre 0 e 4.");
            }
        }
    }
}
