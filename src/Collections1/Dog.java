package Collections1;

public class Dog {
	
	private String raza;
	private int edad;
	public Dog(String raza, int edad) {
		super();
		this.raza = raza;
		this.edad = edad;
	}
	public Dog() {
		super();
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Dog [raza=" + raza + ", edad=" + edad + "]";
	}
	
}
