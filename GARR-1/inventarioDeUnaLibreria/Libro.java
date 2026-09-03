package libreria;

public class Libro {
	
	private String titulo;
	private String autor;
	private int ejemplaresDisponibles;
	
	public Libro(String titulo, String autor, int ejemplaresDisponibles) {
		this.titulo = titulo;
		this.autor = autor;
		this.setEjemplaresDisponibles(ejemplaresDisponibles);
	}

	public int getEjemplaresDisponibles() {
		return ejemplaresDisponibles;
	}

	public void setEjemplaresDisponibles(int nuevaCantidad) {
		if (nuevaCantidad <= 0)
			throw new Error("Cantidad inválida");
		this.ejemplaresDisponibles = nuevaCantidad; 
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}
	
	
	
	

}
