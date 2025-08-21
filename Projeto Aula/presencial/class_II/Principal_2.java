package presencial.class_II;

import presencial.class_II.dao.FilmeDAO;
import presencial.class_II.dao.FilminhoDAO;
import presencial.class_II.model.Filme;
import presencial.class_II.model.Filminho;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Principal_2 {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        try (Scanner sca = new Scanner(System.in)) {
            System.out.println("\n\n\n\n");
            System.out.println("===================================");
            System.out.println("          MENU DO SISTEMA          ");
            System.out.println("===================================");
            System.out.println("1 - ADICIONAR NOVO");
            System.out.println("2 - PESQUISAR");
            System.out.println("3 - EDITAR FILME");
            System.out.println("4 - DELETAR");
            System.out.println("5 - LISTAR FILMES");
            System.out.println("6 - FECHAR");
            System.out.println("===================================");
            System.out.print("OPCAO: ");
            int opcao = sca.nextInt();

            switch (opcao) {
                case 1:
                    novo();
                    break;
                case 2:
                    pesquisa();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    listar();
                    break;
                case 6:
                    sair();
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
    }

    public static void novo() {
        try (Scanner scanner = new Scanner(System.in)) {
            Filminho filminho = new Filminho();
            FilminhoDAO filminhoDAO = new FilminhoDAO();

            System.out.println("\n\n\n\n\n");
            System.out.println("=================================");
            System.out.print("DIGITE O AUTOR DO FILME: ");
            String autor = scanner.nextLine();

            System.out.print("DIGITE OA PRODUTORA DO FILME: ");
            String produtora = scanner.nextLine();

            filminho.setAutor(autor);
            filminho.setProdutora(produtora);
            filminhoDAO.save(filminho);

            System.out.println("=================================");
            System.out.print("APERTE 'ENTER' PARA SAIR");
            @SuppressWarnings("unused")
            String enter = scanner.nextLine();
            menu();
        }
    }

    public static void pesquisa() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n\n\n\n\n");
            System.out.println("=================================");
            System.out.print("DIGITE O ID DO FILME: ");
            int number = scanner.nextInt();

            FilminhoDAO filminhoDAO2 = new FilminhoDAO();
            Optional<Filminho> filminho2;
            filminho2 = filminhoDAO2.getbyID(number);

            if (filminho2.isEmpty()) {
                System.out.println("\n");
                System.out.println("=============!ATENCAO!=============");
                System.out.println("NAO FOI ENCONTRADO NENHUM RESULTADO");
                System.out.println("===================================");
            } else {
                System.out.println("=================================");
                System.out.print("O AUTOR DO ID: " + number + " É ");
                System.out.println(filminho2.get().getAutor());
                System.out.println("=================================");
            }
            menu();
        }
    }

    public static void update() {
        try (Scanner scanner = new Scanner(System.in);
             Scanner leitor = new Scanner(System.in);
             Scanner scan = new Scanner(System.in)) {

            System.out.println("\n\n\n\n\n");
            System.out.println("=================================");
            System.out.print("DIGITE O ID DO FILME: ");
            int number = scanner.nextInt();

            FilminhoDAO filminhoDAO3 = new FilminhoDAO();
            Filminho filminho3 = new Filminho();
            filminho3.setId(number);

            System.out.println("=================================");
            System.out.print("DIGITE O AUTOR DO FILME: ");
            String autor = leitor.nextLine();
            filminho3.setAutor(autor);

            System.out.print("DIGITE A PRODUTORA DO FILME: ");
            String produtora = scan.nextLine();
            filminho3.setProdutora(produtora);
            filminhoDAO3.updatebyID(filminho3);

            System.out.println("\n\n\n\n");
            System.out.println("=============!ATENCAO!=============");
            System.out.println("    FILME ALTERADO COM SUCESSO!    ");
            System.out.println("===================================");
            System.out.print("APERTE 'ENTER' PARA SAIR");
            try (Scanner reader = new Scanner(System.in)) {
                @SuppressWarnings("unused")
                String enter = reader.nextLine();
                menu();
            }
        }
    }

    public static void delete() {
        try (Scanner scanner = new Scanner(System.in); Scanner leitor = new Scanner(System.in)) {

            System.out.println("\n\n\n\n\n");
            System.out.println("=================================");
            System.out.print("DIGITE O ID DO FILME: ");
            int number = scanner.nextInt();

            FilminhoDAO filminhoDAO4 = new FilminhoDAO();
            Filminho filminho4 = new Filminho();
            filminho4.setId(number);
            filminhoDAO4.deletebyID(filminho4);

            System.out.println("\n\n\n\n");
            System.out.println("=============!ATENCAO!=============");
            System.out.println("    FILME EXCLUIDO COM SUCESSO!    ");
            System.out.println("===================================");
            System.out.print("APERTE 'ENTER' PARA SAIR");
            @SuppressWarnings("unused")
            String enter = leitor.nextLine();
            menu();
        }
    }

    public static void listar() {
        try (Scanner scanner = new Scanner(System.in)) {
            FilminhoDAO filminhoDAO5 = new FilminhoDAO();
            ArrayList listfilminhos;
            listfilminhos = (ArrayList) filminhoDAO5.getAll();

            System.out.println("\n\n\n\n");
            System.out.println("===================================");
            System.out.println("          LISTA DE FILMES          ");
            System.out.println("===================================");
            for (Object listfilminho : listfilminhos) {
                Filminho filminho124 = (Filminho) listfilminho;
                System.out.println(filminho124.getId() + ": " + filminho124.getAutor() + " - " + filminho124.getProdutora());
            }
            System.out.println("===================================");
            System.out.print("APERTE 'ENTER' PARA SAIR");
            @SuppressWarnings("unused")
            String enter = scanner.nextLine();
            menu();
        }
    }

    public static void sair() {
        System.out.println("\n\n\n\n");
        System.out.print("FINALIZANDO O SISTEMA. . .");
    }
}
