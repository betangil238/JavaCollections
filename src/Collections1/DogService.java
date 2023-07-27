package Collections1;

import java.util.ArrayList;
import java.util.Scanner;

public class DogService {
	Scanner leer= new Scanner(System.in);
	ArrayList<String> razas = new ArrayList<>();
	
	public ArrayList<String> AlmacenarMostrarRazas(){
		
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
		return razas;	
	}
	
}


