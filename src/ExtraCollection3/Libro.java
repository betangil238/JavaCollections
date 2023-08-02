package ExtraCollection3;

public class Libro {
	private String titulo;
	private String autor;
	private int ejemplares;
	private int prestados;
	
	public Libro() {
		super();
	}
	public Libro(String titulo, String autor, int ejemplares, int prestados) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplares = ejemplares;
		this.prestados = prestados;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}
	public int getPrestados() {
		return prestados;
	}
	public void setPrestados(int prestados) {
		this.prestados = prestados;
	}
	@Override
	public String toString() {
		return "[titulo=" + titulo + ", autor=" + autor + ", ejemplares=" + ejemplares + ", prestados="
				+ prestados + "]";
	}

	
}
