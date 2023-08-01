package ExtraCollection2;

public class Cantante {
	private String nombre;
	private String discoConMasVentas;
	public Cantante(String nombre, String discoConMasVentas) {
		super();
		this.nombre = nombre;
		this.discoConMasVentas = discoConMasVentas;
	}
	public Cantante() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDiscoConMasVentas() {
		return discoConMasVentas;
	}
	public void setDiscoConMasVentas(String discoConMasVentas) {
		this.discoConMasVentas = discoConMasVentas;
	}
	@Override
	public String toString() {
		return "nombre=" + nombre + ", disco mas vendido=" + discoConMasVentas;
	}
	
	

}
