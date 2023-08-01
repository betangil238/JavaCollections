package Collection6;
//Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
//productos que venderemos y el precio que tendrán. Además, se necesita que la
//aplicación cuente con las funciones básicas.
//Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
//eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
//Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
//Realizar un menú para lograr todas las acciones previamente mencionadas.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tienda {
	HashMap<String,Double> productos = new HashMap<>();
	Scanner leer= new Scanner(System.in);
	
	
	public void Menu() {
		boolean continuar=true;
		PrecargarProductos();
		while (continuar) {
			System.out.println("BIENVENIDO AL MENU DE LA TIENDA");
			System.out.println("1) Agregar elemento");
			System.out.println("2) Modificar Precio");
			System.out.println("3) Eliminar Producto");
			System.out.println("4) Mostrar Productos");
			System.out.println("0) Salir");
			int opcion=leer.nextInt();
			switch (opcion) { 
		    case 1:
		    	AgregarElemento();
		     break;
		    case 2:
		    	ModificarPrecio();
		     break;
		    case 3:
		    	EliminarProducto();
		     break;
		    case 4:
		    	MostrarProductos();
			     break;
		    case 0:
		    	System.out.println("Muchas gracias!");
		    	continuar=false;
			     break;
		    default:
		     System.out.println("opcion erronea");
		  }
		}
	}
	
	public void AgregarElemento() {
		System.out.println("Ingrese el nombre del producto");
		String producto = leer.next();
		leer.nextLine();
		int opcion=0;
		if(productos.containsKey(producto)) {
			System.out.println("El producto ya se encuentra registrado");
			System.out.println("Desea actualizar el precio? YES/SI=1  NO=2");
			opcion=leer.nextInt();
		}
		if (opcion==1) {
			System.out.println("Ingrese el precio del producto");
			Double precio=leer.nextDouble();
			productos.put(producto, precio);
			System.out.println("Producto ACTUALIZADO con exito");
		}else if(opcion==0) {
			System.out.println("Ingrese el precio del producto");
			Double precio=leer.nextDouble();
			productos.put(producto, precio);
			System.out.println("Producto agregado con exito");
		}
		
	}
	
	public void ModificarPrecio() {
		System.out.println("Ingrese el nombre del producto a buscar");
		String producto = leer.next();
		leer.nextLine();
		if(productos.containsKey(producto)) {
			System.out.println("Ingrese el valor actualizado");
			productos.replace(producto, leer.nextDouble());
			System.out.println("Producto modificado correctamente");
		}else {
			System.out.println("No se encontro producto con el nombre");
		}
	}
	
	
	public void EliminarProducto() {
		System.out.println("SISTEMA DE ELIMINACION DE PRODUCTOS");
		System.out.println("Ingrese el nombre del producto a eliminar");
		String producto = leer.next();
		leer.nextLine();
		if(productos.containsKey(producto)) {
			productos.remove(producto);
			System.out.println("Producto eliminado correctamente");
		}else {
			System.out.println("No se encontro producto con el nombre");
		}
		
	}
	
	public void MostrarProductos() {
		System.out.println("LISTADO DE PRODUCTOS EN LA BASE DE DATOS");
		int contador=0;
		for(Map.Entry<String,Double> producto:productos.entrySet()) {
			contador++;
			System.out.println("Producto "+contador+") "+producto.getKey()+ " Precio = $ "+producto.getValue());
		}
	}
	
	private void PrecargarProductos() {
		productos.put("Arroz", (double) 2850);
		productos.put("Harina", (double) 1850);
		productos.put("Leche", (double) 3700);
		productos.put("Pan", (double) 5200);
		productos.put("Tomate", (double) 2320);
	}

}
