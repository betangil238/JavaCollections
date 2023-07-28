package Collections2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
//Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
//un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
//está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
//ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
//la lista ordenada.
public class DogService {
	Scanner leer= new Scanner(System.in);
	ArrayList<String> razas = new ArrayList<>();
	
	public ArrayList<String> AlmacenarYEliminar(){
		
		boolean continuar=true;
		
		while (continuar) {
			System.out.println("Ingrese una raza de perro");
			razas.add(leer.next());
			System.out.println("Desea agregar otra raza? 1=Si/Yes 2=No");
			int opc=leer.nextInt();
			continuar=(opc==1) ? true: false;
		}
		System.out.println("Muchas gracias por agregar las razas, estas son las razas");
		for (String raza: razas) {
			System.out.println(raza);
		}
		Iterator<String> iterator= razas.iterator();
		System.out.println("Ingrese la raza a ser eliminada");
		String razaVerificar=leer.next();
		int contador=0;
		while(iterator.hasNext()) {
			contador++;
			if(iterator.next().equals(razaVerificar)) {
				System.out.println("La raza de perro: "+ razaVerificar+ " fue eliminada");
				razas.remove(razaVerificar);
				break;
			}else if(razas.size()==contador) {
				System.out.println("Lo sentimos, no se encontro coincidencia");
			}
		}
		Imprimir();
		return razas;	
	}
	
	public void Imprimir() {
		System.out.println();
		System.out.println("Aqui estan las razas ordenadas alfabeticamente");
		Collections.sort(razas);
		for (String raza: razas) {
			System.out.println(raza);
		}
	}
	
}


