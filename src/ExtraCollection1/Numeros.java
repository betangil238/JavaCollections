package ExtraCollection1;
//Diseñar un programa que lea una serie de valores numéricos enteros desde el teclado y
//los guarde en un ArrayList de tipo Integer. La lectura de números termina cuando se
//introduzca el valor -99. Este valor no se guarda en el ArrayList. A continuación, el
//programa mostrará por pantalla el número de valores que se han leído, su suma y su
//media (promedio).

import java.util.ArrayList;
import java.util.Scanner;

public class Numeros {
	ArrayList<Integer> numeros=new ArrayList<>();
	Scanner leer= new Scanner(System.in);
	public void agregarnumeros() {
		Integer n=0;
		Integer sum=0;
		while(n!=-99) {
			System.out.println("Ingrese un numero");
			n=leer.nextInt();
			if(n!=-99) {
				System.out.println(sum);
				sum+=n;
				System.out.println(sum);
				numeros.add(n);
			}else {
				int cantidad=numeros.size();
				System.out.println("Se han leido: "+cantidad +" numeros y 1 numero erroneo");
				System.out.println("El promedio es: "+ (sum/cantidad));
			}
		};
	}
}
