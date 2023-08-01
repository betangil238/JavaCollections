package ExtraCollection2;
import java.util.ArrayList;
import java.util.Scanner;
//Crear una clase llamada CantanteFamoso. Esta clase guardará cantantes famosos y
//tendrá como atributos el nombre y discoConMasVentas.
//Se debe, además, en el main, crear una lista de tipo CantanteFamoso y agregar 5 objetos
//de tipo CantanteFamoso a la lista. Luego, se debe mostrar los nombres de cada cantante
//y su disco con más ventas por pantalla.
//Una vez agregado los 5, en otro bucle, crear un menú que le de la opción al usuario de
//agregar un cantante más, mostrar todos los cantantes, eliminar un cantante que el usuario
//elija o de salir del programa. Al final se deberá mostrar la lista con todos los cambios
public class CantanteService {
	Scanner leer= new Scanner(System.in);
	ArrayList<Cantante> cantantes = new ArrayList<>();
	
	public void crearCantante() {
		precargarcantantes();
		while(cantantes.size()<5) {
			agregarCantante();
		}
		System.out.println("ESTOS SON LOS CANTANTES");
		imprimir();
		menu();
	}

	private void menu() {
		int opcion=9;
		while(opcion!=0) {
			System.out.println("BIENVENIDO AL MENU");
			System.out.println("1) Agregar un cantante");
			System.out.println("2) Mostrar todos los cantantes");
			System.out.println("3) Eliminar un cantante");
			System.out.println("0) salir");
			System.out.print(" Ingrese una opcion: ");
			opcion= leer.nextInt();
			switch (opcion) {
			case 1:
				agregarCantante();
				break;
			case 2:
				imprimir();
				break;
			case 3:
				eliminarCantante();
				break;	
			case 0:
				System.out.println("Muchas gracias");
				break;
			default:
				System.out.println("Dato erroneo");
				break;
			}
		}	
	}

	private void eliminarCantante() {
		System.out.println("Ingrese el nombre del cantante a ser eliminado");
		String nombre = leer.next();
		int tamano1=cantantes.size();
		cantantes.removeIf(p->p.getNombre().equals(nombre));
		int tamano2=cantantes.size();
		if (tamano2==tamano1) {
			System.out.println("No se encontro coincidencia");
		}else {
			System.out.println("Eliminacion Exitosa");
		}		
	}

	private void precargarcantantes() {
		cantantes.add(new Cantante("Joe Arroyo", "Tal para Cual"));
		cantantes.add(new Cantante("Silvestre Dangond", "Esto es vida"));
		cantantes.add(new Cantante("Diomedez Diaz", "Mi biografía"));
		cantantes.add(new Cantante("Juanes", "Mi sangre"));
	}
	
	public void imprimir() {
		int contador=0;
		for (Cantante cantante: cantantes) {
			contador++;
			System.out.println("Cantante "+ contador+") " +cantante);
		}
	}
	
	private void agregarCantante() {
		System.out.println("Ingrese el nombre del cantante");
		String nombre = leer.next();
		leer.nextLine();
		System.out.println("Ingrese el disco mas popular");
		String disco = leer.next();
		leer.nextLine();
		Cantante cantante = new Cantante(nombre, disco);
		cantantes.add(cantante);
	}

}
