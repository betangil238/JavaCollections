package ExtraCollection3;
//Implemente un programa para una Librería haciendo uso de un HashSet para evitar datos
//repetidos. Para ello, se debe crear una clase llamada Libro que guarde la información de
//cada uno de los libros de una Biblioteca. La clase Libro debe guardar
//el título del libro, autor, número de ejemplares y número de ejemplares prestados.
//También se creará en el main un HashSet de tipo Libro que guardará todos los libros
//creados.
//En el main tendremos un bucle que crea un objeto Libro pidiéndole al usuario todos sus
//datos y los seteandolos en el Libro. Despues, ese Libro se guarda en el conjunto y se le
//pregunta al usuario si quiere crear otro Libro o no.
//La clase Librería contendrá además los siguientes métodos:
//● Constructor por defecto.
//● Constructor con parámetros.
//● Métodos Setters/getters
//● Método prestamo(): El usuario ingresa el titulo del libro que quiere prestar y se lo busca
//en el conjunto. Si está en el conjunto, se llama con ese objeto Libro al método. El
//método se incrementa de a uno, como un carrito de compras, el atributo ejemplares
//prestados, del libro que ingresó el usuario. Esto sucederá cada vez que se realice un
//préstamo del libro. No se podrán prestar libros de los que no queden ejemplares
//disponibles para prestar. Devuelve true si se ha podido realizar la operación y false en
//caso contrario.
//● Método devolucion(): El usuario ingresa el titulo del libro que quiere devolver y se lo
//busca en el conjunto. Si está en el conjunto, se llama con ese objeto al método. El
//método decrementa de a uno, como un carrito de compras, el atributo ejemplares
//prestados, del libro seleccionado por el usuario. Esto sucederá cada vez que se
//produzca la devolución de un libro. No se podrán devolver libros donde que no tengan
//ejemplares prestados. Devuelve true si se ha podido realizar la operación y false en
//caso contrario.
//● Método toString para mostrar los datos de los libros.

import java.util.HashSet;
import java.util.Scanner;

public class LibreriaService {
	Scanner leer = new Scanner(System.in);
	HashSet<Libro> libros = new HashSet<>();
	public void crearLibro() {
		boolean condicion=true;
		while(condicion) {
			System.out.println("Ingrese el nombre del libro");
			String titulo=leer.next();
			leer.nextLine();
			System.out.println("Ingrese el nombre del autor");
			String autor=leer.next();
			leer.nextLine();
			System.out.println("Ingrese la cantidad de ejemplares");
			int ejemplares=leer.nextInt();
			int prestados;
			do {
				System.out.println("Ingrese la cantidad de ejemplares prestados");
				prestados=leer.nextInt();
			}while(ejemplares<prestados);
			libros.add(new Libro(titulo, autor, ejemplares, prestados));
			System.out.println("Desea agregar otro libro YES/SI=1 NO=2");
			int opcion = leer.nextInt();
			if (opcion==1) {
				condicion=true;
			}else {
				condicion=false;
			}
		}
	}
	
	private void imprimir() {
		System.out.println("Estos son los libros");
		int count=0;
		for (Libro libro: libros) {
			count++;
			System.out.println(count + ") "+libro);
		}
	}
	
	public boolean devolucion() {
		imprimir();
		System.out.println("Ingrese el titulo del libro a devolver");
		String libro=leer.next();
		int contador=0;
		for (Libro book: libros) {
			contador++;
			if (book.getTitulo().equals(libro)) {
				int disponibles= book.getEjemplares()-book.getPrestados();
				if(disponibles==0) {
					System.out.println("Perfecto, Alguien solicitaba este libro");
				}
				if (disponibles==book.getEjemplares()) {
					System.out.println("Ha ingresado un titulo incorrecto, la Libreria cuenta ya con todos los ejemplares");
					return false;
				}else {
					book.setPrestados(book.getPrestados()-1);
					System.out.println("Libro devuelto con exito");
					return true;
				}
				
			}
			if (contador==libros.size()) {
				System.out.println("Titulo no encontrado");
				return false;
			}
		}
		return false;
	}
	
	public boolean prestamo() {
		imprimir();
		System.out.println("Ingrese el titulo del libro a prestar");
		String libro=leer.next();
		int contador=0;
		for (Libro book: libros) {
			contador++;
			if (book.getTitulo().equals(libro)) {
				int disponibles= book.getEjemplares()-book.getPrestados();
				if(disponibles==0) {
					System.out.println("Lo sentimos actualmente este libro esta reservado completamente");
					return false;
				}
				System.out.println("Libro encontrado con exito, hay "+disponibles+" libros disponibles");
				System.out.println("Cuantos desea prestar");
				int prestamo=leer.nextInt();
				
				if(prestamo<=disponibles) {
					book.setPrestados(book.getPrestados()+prestamo);
					System.out.println("Libro prestado con exito");
					return true;
				}else {
					System.out.println("Accion imposible, no hay libros suficientes");
					return false;
				}
			}
			if (contador==libros.size()) {
				System.out.println("Titulo no encontrado");
				return false;
			}
		}
		return false;
	}
	
	public void precarga() {
		libros.add(new Libro("El amor en los tiempo del colera", "Gabriel garcia marquez", 10, 3));
		libros.add(new Libro("El arte de la guerra", "Sunt Zu", 12, 1));
		libros.add(new Libro("El autopista", "RL Stines", 3, 1));
		libros.add(new Libro("Un mundo feliz", "Aldous Huxley", 1, 0));
	}
	
	public void menu() {
		int key=9;
		while(key!=0) {
			System.out.println("BIENVENIDO AL MENU");
			System.out.println("1) Crear libro");
			System.out.println("2) Mostrar libros");
			System.out.println("3) Prestar libros");
			System.out.println("4) Devolver libro");
			System.out.println("0) Salir");
			System.out.print("Ingrese la opcion que desea: ");
			key=leer.nextInt();
			switch (key) {
			case 1:
				crearLibro();
				break;
			case 2:
				imprimir();
				break;
			case 3:
				prestamo();
				break;
			case 4:
				devolucion();
				break;
			case 0:
				System.out.println("Muchas gracias");;
				break;
			default:
				System.out.println("Dato incorrecto");
				break;
			}
		}
		
	}
}
