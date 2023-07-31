package Collection4;

public class Pelicula {
	private String titulo;
	private String director;
	private Double duracionHoras;
	
	
	public Pelicula() {
		super();
	}
	public Pelicula(String titulo, String director, Double duracionHoras) {
		super();
		this.titulo = titulo;
		this.director = director;
		this.duracionHoras = duracionHoras;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Double getDuracionHoras() {
		return duracionHoras;
	}
	public void setDuracionHoras(Double duracionHoras) {
		this.duracionHoras = duracionHoras;
	}
	@Override
	public String toString() {
		return "Pelicula [TITULO=" + titulo + ", DIRECTOR=" + director + ", DURACION(h)=" + duracionHoras + "]";
	}

}
