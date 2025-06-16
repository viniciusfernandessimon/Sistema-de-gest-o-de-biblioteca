package GestaoBiblioteca;

public class Livro {
    private int id;
    private String titulo;
    private Autor autor;
    private boolean disponivel;

    public Livro(int id, String titulo, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    
	public int getId() { 
		return id;
	}
    public String getTitulo() { 
    	return titulo; 
	}	
    public Autor getAutor() { 
    	return autor; 
    }
    public boolean isDisponivel() { 
    	return disponivel; 
    }

    public void emprestar() {
        this.disponivel = false;
    }

    public void devolver(){
    	this.disponivel = true;
    }
    
  
    
    @Override
    public String toString() {
        return id + " - " + titulo + " (Autor: " + autor.getNome() + ")";
    }
}

