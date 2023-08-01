package Collection5;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class PaisesService {
//	Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos
//	usaremos un conjunto. El programa pedirá un país en un bucle, se guardará el país en el
//	conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir,
//	si decide salir, se mostrará todos los países guardados en el conjunto. (Recordemos hacer
//	los servicios en la clase correspondiente)
//	Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar
//	cómo se ordena un conjunto.
//	Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se
//	buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el
//	usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará
//	al usuario.
	Scanner leer=new Scanner(System.in);
	HashSet<String> paises = new HashSet<>();
	
	public void AgregarPaises() {
		precargarPaises();
		System.out.println("BIENVENIDO AL CREADOR DE PAISES");
		boolean continuar=true;
		while(continuar) {
			System.out.println("Ingrese el nombre del pais");
			paises.add(leer.next());
			leer.nextLine();
			System.out.println("Desea agregar otro pais Si/Yes=1  No/Salir=2");
			continuar=(leer.nextInt()==1)? true: false;
		}
		imprimir(paises);
		TreeSet<String> paisesordenados= new TreeSet<>(paises);
		System.out.println("AQUI ESTAN LOS PAISES ORDENADOS ALFABETICAMENTE");
		imprimir(paisesordenados);		
}

	private void precargarPaises() {
		paises.add("Colombia");
		paises.add("Argentina");
		paises.add("Peru");
		paises.add("Venezuela");
		paises.add("Paraguay");
		paises.add("Honduras");
		
	}
	private void imprimir(Set<String> arreglo) {
		for (String pais: arreglo) {
			System.out.println(pais);
		}
	}
	
	public void eliminarPais() {
		Iterator<String> iterator = paises.iterator();
		System.out.println("Ingrese el pais que desea remover");
		String paisEliminar=leer.next();
		leer.nextLine();
		int count = 0;
		System.out.println("PAISES ANTES DE DARLE");
		imprimir(paises);
		if(iterator.equals(paisEliminar)) {
			System.out.println("Pais eliminado exitosamente");
			iterator.remove();
			imprimir(paises);
		}else {
			while(iterator.hasNext()) {
				count++;
				if(iterator.next().equals(paisEliminar)) {
					System.out.println("Pais eliminado exitosamente");
					iterator.remove();
					imprimir(paises);
					break;
				}
				if (count==paises.size()) {
					System.out.println("No se encontro coincidencia");
				}
			}
		}		
	}	
}
