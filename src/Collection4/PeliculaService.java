package Collection4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
//Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
//tendremos una clase Pelicula con el título, director y duración de la película (en horas).
//Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
//que se pide a continuación:
//En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
//todos sus datos y guardándolos en el objeto Pelicula.
//Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
//crear otra Pelicula o no.
//Después de ese bucle realizaremos las siguientes acciones:
//	• Mostrar en pantalla todas las películas.
//	• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
//	• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en
//	pantalla.
//	• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en
//	pantalla.
//	• Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.
//	• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
public class PeliculaService {
	Scanner leer= new Scanner(System.in);
	ArrayList<Pelicula> peliculas = new ArrayList<>() ;
	
	public void CrearPelicula() {
		precargarPeliculas();
		System.out.println(peliculas);
		System.out.println("BIENVENIDO AL CREADOR DE PELICULAS");
		boolean continuar=true;
		while(continuar) {
			System.out.println("Ingrese el nombre de la pelicula");
			String nombrePelicula=leer.next();
			leer.nextLine();
			System.out.println("Ingrese el nombre del director");
			String director=leer.next();
			leer.nextLine();
			System.out.println("Ingrese la duracion en horas de la pelicula");
			double duracion=leer.nextDouble();
			Pelicula pelicula= new Pelicula(nombrePelicula, director, duracion);
			peliculas.add(pelicula);
			System.out.println("Desea agregar otra pelicula Si/Yes=1  No=2");
			continuar=(leer.nextInt()==1)? true: false;
		}
		MostrarPeliculas();
		MostrarPeliculasMayor1();
		OrdenarPeliculasDes();
		OrdenarPeliculasAsc();
		OrdenarTitulo();
		OrdenarDirector();
	}
	
	private void OrdenarDirector() {
		System.out.println("CLASIFIQUEMOSLAS POR DIRECTOR ALFABETICAMENTE");
		peliculas.sort(Comparator.comparing(Pelicula::getDirector));
//		peliculas.sort(compararDirector);
		MostrarPeliculas();
	}

	private void OrdenarTitulo() {
		System.out.println("CLASIFIQUEMOSLAS POR TITULO ALFABETICAMENTE");
		peliculas.sort(Comparator.comparing(Pelicula::getTitulo));
//		peliculas.sort(compararTitulo);
		MostrarPeliculas();
	}

	private void OrdenarPeliculasAsc() {
		System.out.println("AHORA DE MENOR A MAYOR");
		Collections.reverse(peliculas);
//		peliculas.sort(compararDuracionAsc);
		MostrarPeliculas();
		
	}

	private void precargarPeliculas() {
		peliculas.add(new Pelicula("Busqueda de la felicidad", "Will Simith", 2.0));
		peliculas.add(new Pelicula("La noche del demonio", "xyz", 1.23));
		peliculas.add(new Pelicula("chef", "jon favreau", 0.8));
		peliculas.add(new Pelicula("El dia despues de manana", "quentin tarantino", 1.5));
	}

	public void OrdenarPeliculasDes() {
		System.out.println("CLASIFIQUEMOSLAS POR TIEMPO");
		peliculas.sort(compararDuracionDesc);
		MostrarPeliculas();
	}

	public void MostrarPeliculasMayor1() {
		System.out.println("ESTAS SON LAS PELICULAS CON DURACION MAYOR A 1 HORA");
		for (Pelicula pelicula: peliculas) {
			if(pelicula.getDuracionHoras()>1) {
				System.out.println(pelicula);
			}
		}
	}

	public ArrayList<Pelicula> MostrarPeliculas() {
		System.out.println("ESTAS SON LAS PELICULAS CREADAS");
		for (Pelicula pelicula: peliculas) {
			System.out.println(pelicula);
		}
		return peliculas;
	}
	
	public static Comparator<Pelicula> compararDuracionDesc= new Comparator<Pelicula>() {
		@Override
		public int compare(Pelicula o1, Pelicula o2) {
			return o2.getDuracionHoras().compareTo(o1.getDuracionHoras());
		}
	};
	
//	public static Comparator<Pelicula> compararDuracionAsc= new Comparator<Pelicula>() {
//		@Override
//		public int compare(Pelicula o1, Pelicula o2) {
//			return o1.getDuracionHoras().compareTo(o2.getDuracionHoras());
//		}
//	};
	
	public static Comparator<Pelicula> compararTitulo= new Comparator<Pelicula>() {
		@Override
		public int compare(Pelicula o1, Pelicula o2) {
			return o1.getTitulo().compareTo(o2.getTitulo());
		}
	};
	
	public static Comparator<Pelicula> compararDirector= new Comparator<Pelicula>() {
		@Override
		public int compare(Pelicula o1, Pelicula o2) {
			return o1.getDirector().compareTo(o2.getDirector());
		}
	};
}
