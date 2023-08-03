package ExtraCollection4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

//Almacena en un HashMap los códigos postales de 10 ciudades a elección de esta
//página: https://mapanet.eu/index.htm. Nota: Poner el código postal sin la letra, solo el
//número.
//• Pedirle al usuario que ingrese 10 códigos postales y sus ciudades.
//• Muestra por pantalla los datos introducidos
//• Pide un código postal y muestra la ciudad asociada si existe sino avisa al usuario.
//• Muestra por pantalla los datos
//• Agregar una ciudad con su código postal correspondiente más al HashMap.
//• Elimina 3 ciudades existentes dentro del HashMap, que pida el usuario.
//• Muestra por pantalla los datos
public class Postales {
	Scanner leer= new Scanner(System.in);
	HashMap<String, Integer> ciudades = new HashMap<>();
	
	private void precargar(){
		ciudades.put("Medellin", 50013);
		ciudades.put("Yateras",99420 );
		ciudades.put("Akrar Hellnum",355 );
		ciudades.put("Beijing",102115 );
		ciudades.put("Singapore", 786205);
		ciudades.put("Aragua",2117 );
		ciudades.put("San lorenzo",80503);
		ciudades.put("Agana",96932 );
		ciudades.put("Torino",10060 );
		ciudades.put("Antartida",7151 );		
	}
	
	public void Menu(){
		precargar();
		int opc=9;
		while(opc!=0) {
			System.out.println("**BIENVENIDO AL MENU**");
			System.out.println("1) cargar ciudad y codigo postal");
			System.out.println("2) consultar ciudad por codigo postal");
			System.out.println("3) Mostrar ciudades y codigo postal");
			System.out.println("4) Eliminar registro por codigo postal");
			System.out.println("0) Salir");
			opc=leer.nextInt();
			switch (opc) {
			case 1:
				Cargar();
				break;
			case 2:
				Consultar();
				break;
			case 3:
				Imprimir();
				break;
            case 4:
				Eliminar();
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

	private void Eliminar() {
		System.out.println("Ingrese el codigo postal a Eliminar");
		Integer codigo = leer.nextInt();
		int ciclo=0;
		for (Map.Entry<String, Integer> entry: ciudades.entrySet()) {
			ciclo++;
			if(entry.getValue().equals(codigo)) {
				System.out.print("Desea eliminar: ");
				System.out.println("Ciudad: "+ entry.getKey() + " Codigo Postal "+ entry.getValue());
				System.out.println("YES/SI=1 NO=2");
				int opc=leer.nextInt();
				if (opc==1) {
					ciudades.remove(entry.getKey());
					System.out.println("Eliminacion exitosa");
				}else {
					System.out.println("Eliminacion cancelada");
				}
				break;
			}
			if(ciclo==ciudades.size()) {
				System.out.println("No se encontraron coincidencias");
			}
		}
		
	}

	private void Imprimir() {
		int ciclo=0;
		for (Map.Entry<String, Integer> entry: ciudades.entrySet()) {
			ciclo++;
			System.out.println(ciclo+") Ciudad: "+ entry.getKey() + " Codigo Postal "+ entry.getValue());
		}
		
	}

	private void Consultar() {
		System.out.println("Ingrese el codigo postal a consultar");
		Integer codigo = leer.nextInt();
		int ciclo=0;
		for (Map.Entry<String, Integer> entry: ciudades.entrySet()) {
			ciclo++;
			if(entry.getValue().equals(codigo)) {
				System.out.println("Se encontro la ciudad consultada");
				System.out.println("Ciudad: "+ entry.getKey() + " Codigo Postal "+ entry.getValue());
				break;
			}
			if(ciclo==ciudades.size()) {
				System.out.println("No se encontraron coincidencias");
			}
		}
		
	}

	private void Cargar() {
		System.out.println("Ingrese la ciudad");
		String ciudad= leer.next();
		System.out.println("Ingrese el codigo postal");
		ciudades.put(ciudad, leer.nextInt());
		System.out.println("Dato registrado exitosamente");
	}

}
