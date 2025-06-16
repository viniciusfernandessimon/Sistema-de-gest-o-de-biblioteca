package GestaoBiblioteca;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Biblioteca biblioteca = new Biblioteca();
		Scanner scanner = new Scanner(System.in);

		int op;
		do {

			System.out.println();
			System.out.println("------------------ MENU -------------------");

			System.out.println("{1} - Pedir livro (ver todos os livros disponíveis");
			System.out.println("{2} - Devolver livro");
			System.out.println("{3} - Historico de empréstimo");
			System.out.println("{4} - Adicionar livro");
			System.out.println("{5} - Sair");

			op = scanner.nextInt();
			scanner.nextLine();

			switch (op) {
			case 1:

				System.out.println();
				System.out.println("============ Livros Disponiveis ============");
				System.out.println();

				biblioteca.listarLivrosDisponiveis();

				System.out.println();
				System.out.print(" Digite o ID do livro que deseja emprestar: ");
				int idLivro = Integer.parseInt(scanner.nextLine());

				Livro livroEscolhido = biblioteca.buscarLivroPorId(idLivro);
				if (livroEscolhido == null) {
					System.out.println("Livro não disponível ou ID inválido.");
					continue;
				}

				System.out.print(" Digite seu nome: ");
				String nomeUsuario = scanner.nextLine();

				biblioteca.registrarEmprestimo(livroEscolhido, nomeUsuario);
				break;

			case 2:

				System.out.println();
				System.out.println("Deseja devolver um livro? (sim/nao)");
				String resposta2 = scanner.nextLine();

				if (resposta2.equals("sim")) {
					System.out.print("Digite o ID do livro que deseja devolver: ");
					int idLivroDevolver = Integer.parseInt(scanner.nextLine());

					System.out.print("Digite seu nome: ");
					String nomeUsuarioDevolver = scanner.nextLine();

					biblioteca.devolverLivro(idLivroDevolver, nomeUsuarioDevolver);

				} else if (resposta2.equals("nao")) {
					System.out.println("Sistemas encerrado. Obrigado por Usar.");
					break;
				}
				break;

			case 3:

				System.out.println("Digite seu nome para ver o hitórico de empréstimos: ");
				nomeUsuario = scanner.nextLine();
				biblioteca.buscarHistorico(nomeUsuario);

				break;

			case 4:

				
				System.out.println("Digite o autor do livro: ");
				String nomeAutor = scanner.nextLine();
				Autor autor = new Autor(nomeAutor);
				System.out.println("Digite o título do livro: ");
				String titulo = scanner.nextLine();
				biblioteca.novoId();

				biblioteca.adicionarLivro(nomeAutor, biblioteca.novoId(), titulo);

				break;

			case 5:

				System.out.println("Sistema encerrado. Obrigado por usar!");
				break;

			default:

				System.out.println("Operação inválida.");
				break;
			}

		} while (op != 5);
	}

}
