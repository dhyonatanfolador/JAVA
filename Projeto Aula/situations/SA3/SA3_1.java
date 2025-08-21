package situations.SA3;

import java.util.Scanner;

public class SA3_1 {
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\n\n");
        System.out.println("===================================");
        System.out.println("          MENU DO SISTEMA          ");
        System.out.println("===================================");
        System.out.println("1 - CALCULAR TROCO");
        System.out.println("2 - FECHAR SISTEMA");
        System.out.println("===================================");
        System.out.print("OPCAO: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                calcular();     //ENVIA PARA 'CALCULAR'
                break;
            case 2:
                sair();     //ENVIA PARA 'SAIR'
                break;
            default:
                System.out.println("\n\n\n\n");
                System.out.println("=============!ATENCAO!=============");
                System.out.println("NAO CONSEGUIMOS TERMINAR A OPERACAO");
                System.out.println("===================================");
                menu();
                break;
        }
    }
    public static void calcular() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\n\n");
        System.out.println("===================================");
        System.out.println("          CALCULAR TROCO           ");
        System.out.println("===================================");
        System.out.print("DIGITE O VALOR TOTAL DE COMPRAS: ");
        double total_compras = scanner.nextDouble();

        System.out.print("DIGITE O VALOR RECEBIDO: ");
        double recebido = scanner.nextDouble();

        double troco = recebido - total_compras;
        if (troco < 0) {
            System.out.println("\n\n\n\n");
            System.out.println("=============!ATENCAO!=============");
            System.out.println("    VALOR RECEBIDO INSUFICIENTE    ");
            System.out.println("===================================");
            menu();
        } else {
            System.out.println("\n");
            System.out.printf("O TROCO É: R$ %.2f", troco);
            System.out.println("\n=================================");
            troco(troco);
        }
    }
    public static void troco(double troco) {
        Scanner scanner = new Scanner(System.in);

        double[] valores = {
                100.0, 50.0, 20.0, 10.0, 5.0, 2.0,
                1.0, 0.50, 0.25, 0.10, 0.05, 0.01};
        String[] texto = {
                "Nota: R$ 100,00", "Nota: R$ 50,00", "Nota: R$ 20,00", "Nota: R$ 10,00",
                "Nota: R$ 5,00", "Nota: R$ 2,00", "Moeda: R$ 1,00", "Moeda: R$ 0,50",
                "Moeda: R$ 0,25", "Moeda: R$ 0,10", "Moeda: R$ 0,05", "Moeda: R$ 0,01"};

        for (int i = 0; i < valores.length; i++) {
            double quantidade = Math.floor(troco / valores[i]);

            if (quantidade > 0) {
                System.out.printf("%.0f%s %s%n", quantidade, ".", texto[i]);
                troco -= quantidade * valores[i];
            }
        }
        System.out.println("=================================");
        System.out.print("APERTE 'ENTER' PARA SAIR");
        String enter = scanner.nextLine(); menu();
    }
    public static void sair() {
        System.out.println("\n\n\n\n");
        System.out.print("FINALIZANDO O SISTEMA. . .");
    }
}
