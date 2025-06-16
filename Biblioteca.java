package GestaoBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<Livro> livros = new ArrayList<>();
	private List<Autor> autores = new ArrayList<>();
	private List<Emprestimo> emprestimos = new ArrayList<>();

	public Biblioteca() {

		Autor autor1 = new Autor("Machado de Assis");
		Autor autor2 = new Autor("Clarice Lispector");
		autores.add(autor1);
		autores.add(autor2);

		livros.add(new Livro(1, "Dom Casmurro", autor1));
		livros.add(new Livro(2, "A Hora da Estrela", autor2));
		livros.add(new Livro(3, "Felicidade Clandestina", autor2));

	}

	public void listarLivrosDisponiveis() {
		for (Livro livro : livros) {
			if (livro.isDisponivel()) {
				System.out.println(livro);
			}
		}
	}

	public Livro buscarLivroPorId(int id) {
		for (Livro livro : livros) {
			if (livro.getId() == id && livro.isDisponivel()) {
				return livro;
			}
		}
		return null;
	}

	public void registrarEmprestimo(Livro livro, String nomeUsuario) {
		livro.emprestar();
		emprestimos.add(new Emprestimo(livro, nomeUsuario));
		System.out.println("Livro emprestado com sucesso para " + nomeUsuario + "!");
	}

	// EXPLICAÇÃO DO MÉTODO DEVOLVER LIVRO:
	// O livro.getid() representa o id do livro que foi emprestado, ja oidLivro
	// representa o id que o usuario digitar.
	// O metodo faz a verificação, vendo se os ids são iguais e tambem verifica se o
	// nome de usuario que foi registrado no
	// emprestimo (getNomeUsuario()) é igual ao nome que o usuario digitar.

	public void devolverLivro(int idLivro, String nomeUsuario) {
		for (Emprestimo emprestimo : emprestimos) {
			Livro livro = emprestimo.getLivro();

			if (livro.getId() == idLivro && emprestimo.getNomeUsuario().equalsIgnoreCase(nomeUsuario)) {
				livro.devolver();

				System.out.println("Livro devolvido com sucesso!");
				return;
			}
		}

		System.out.println("Empréstimo não encontrado. Verifique os dados.");
	}

	//EXPLICAÇÃO DO MÉTODO ADICIONAR LIVRO:
	// Cria um objeto do tipo Autor com o nome passado como argumento. Autor tem um
	// construtor que aceita um String com o nome.
	// A mesma coisa acontece com o objeto novoLivro.

	public void adicionarLivro(String nome, int id, String titulo) {

		Autor novoAutor = new Autor(nome);
		autores.add(novoAutor);
		Livro novoLivro = new Livro(id, titulo, novoAutor);
		livros.add(novoLivro);

		System.out.println("Livro cadastrado com sucesso!");
	}

	public void buscarHistorico(String nomeUsuario) {

		boolean encontrado = false;

		System.out.println();
		System.out.println("Histórico dos emprestimos de " + nomeUsuario + ":");

		for (Emprestimo emprestimo : emprestimos) {

			if (emprestimo.getNomeUsuario().equalsIgnoreCase(nomeUsuario)) {
				System.out.println(emprestimo);
				encontrado = true;

			}
			if (!encontrado) {
				System.out.println("Histórico não encontrado.");
			}

		}

	}

	 public int novoId() {
		 int novoId = 1;
		for (Livro livro : livros) {
			if (livro.getId() >= novoId) {
				novoId = livro.getId() + 1;

			}

		}

		return novoId;

	}
}
