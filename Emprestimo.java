package GestaoBiblioteca;

public class Emprestimo {
	
    private Livro livro;
    
    public Emprestimo(Livro livro, String nomeUsuario) {
        this.livro = livro;
        this.nomeUsuario = nomeUsuario;
    }
    
    
    public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	private String nomeUsuario;


    @Override
    public String toString() {
        return nomeUsuario + " emprestou " + livro.getTitulo() ;
    }
}
