package presencial.class_II;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import presencial.class_II.dao.FilmeDAO;
import presencial.class_II.model.Filme;

public class Principal {
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
			Filme filme = new Filme();
			FilmeDAO filmedao = new FilmeDAO();

			System.out.println("\n\n\n\n\n");
			System.out.println("=================================");
			System.out.print("DIGITE O GENERO DO FILME: ");
			String genero = scanner.nextLine();

			System.out.print("DIGITE O TITULO DO FILME: ");
			String titulo = scanner.nextLine();

			filme.setGenero(genero);
			filme.setTitulo(titulo);
			filmedao.save(filme);

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

			FilmeDAO filmedao2 = new FilmeDAO();
			Optional<Filme> filme2;
			filme2 = filmedao2.getbyID(number);

			if (filme2.isEmpty()) {
				System.out.println("\n");
				System.out.println("=============!ATENCAO!=============");
				System.out.println("NAO FOI ENCONTRADO NENHUM RESULTADO");
				System.out.println("===================================");
			} else {
				System.out.println("=================================");
				System.out.print("O FILME DO ID: " + number + " É ");
				System.out.println(filme2.get().getTitulo());
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

			FilmeDAO filmedao3 = new FilmeDAO();
			Filme filme3 = new Filme();
			filme3.setId(number);

			System.out.println("=================================");
			System.out.print("DIGITE O GENERO DO FILME: ");
			String genero = leitor.nextLine();
			filme3.setGenero(genero);

			System.out.print("DIGITE O TITULO DO FILME: ");
			String titulo = scan.nextLine();
			filme3.setTitulo(titulo);
			filmedao3.updatebyID(filme3);

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

			FilmeDAO filmedao4 = new FilmeDAO();
			Filme filme4 = new Filme();
			filme4.setId(number);
			filmedao4.deletebyID(filme4);

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
			FilmeDAO filmedao5 = new FilmeDAO();
			ArrayList<?> listfilmes;
			listfilmes = (ArrayList<?>) filmedao5.getAll();

			System.out.println("\n\n\n\n");
			System.out.println("===================================");
			System.out.println("          LISTA DE FILMES          ");
			System.out.println("===================================");
            for (Object listfilme : listfilmes) {
                Filme filme124 = (Filme) listfilme;
                System.out.println(filme124.getId() + ": " + filme124.getTitulo());
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
