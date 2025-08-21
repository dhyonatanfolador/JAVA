package presencial.class_I;

import java.util.Scanner;

public class Atividade_1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int num1 = 0;
            int num2 = 0;
            int valor = 0;

            System.out.print("Digite um numero: ");
            num1 = scanner.nextInt();
            System.out.print("Digite outro numero: ");
            num2 = scanner.nextInt();

            System.out.println("Qual operacao gostaria de realizar?");
            System.out.println("1 - Adicao, 2 - Subtracao \n3 - Multiplicacao, 4 - Divisao");
            System.out.print("___________________\nOpcao: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    valor = num1 + num2;
                    System.out.println("\n\nO valor é: " + valor);
                    break;
                case 2:
                    valor = num1 - num2;
                    System.out.println("\n\nO valor é: " + valor);
                    break;
                case 3:
                    valor = num1 * num2;
                    System.out.println("\n\nO valor é: " + valor);
                    break;
                case 4:
                    valor = num1 / num2;
                    System.out.println("\n\nO valor é: " + valor);
                    break;
                default:
                    System.out.println("\n\nValor incorreto!\n\n");
                    main(null);
                    break;
            }
        }
    }
}
