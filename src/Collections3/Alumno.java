package Collections3;

public class Alumno {
	private String nombre;
	private double[] notas;
	public Alumno(String nombre, double[] notas) {
		this.nombre = nombre;
		this.notas = new double[3];
	}
	public Alumno() {
		this.notas = new double[3];
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double[] getNotas() {
		return notas;
	}
	public void setNotas(double[] notas) {
		this.notas = notas;
	}
//	@Override
//	public String toString() {
//		return "Alumno [nombre=" + nombre + ", notas=" + Arrays.toString(notas) + "]";
//	}
	
}
