package Collections3;

import java.util.ArrayList;
import java.util.Scanner;
//Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
//alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer
//con sus 3 notas.

//En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
//toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
//pregunta al usuario si quiere crear otro Alumno o no.

//Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
//Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
//final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
//del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
//promedio final, devuelto por el método y mostrado en el main.

public class AlumnoService {
	
	Scanner leer= new Scanner(System.in);
	ArrayList<Alumno> listaAlumno= new ArrayList<>();
	
	
	public ArrayList<Alumno> CrearAlumnos(){
	boolean continuar=true;
	int contadorAlumnos=0;
		while (continuar) {
			double[] notasauxiliar= new double[3];
			Alumno alumno = new Alumno();
			contadorAlumnos++;
			System.out.println("Ingrese los datos del alumno "+contadorAlumnos);
			System.out.println("Ingrese el nombre del alumno");
			alumno.setNombre(leer.next());
			int contadorNotas=0;
			for (int i = 0;i<3;i++) {
				System.out.println("Ingrese la nota: "+ (contadorNotas+1) );
				notasauxiliar[i]=leer.nextDouble();
				contadorNotas++;
			}
			alumno.setNotas(notasauxiliar);
			listaAlumno.add(alumno);
			System.out.println("Desea agregar otro alumno? 1=Si/Yes 2=No");
			int opc=leer.nextInt();
			continuar=(opc==1) ? true: false;
		}
		return listaAlumno;
		
	}
	
	public double notaFinal() {
		System.out.println("Ingrese el nombre del alumno a buscar");
		String nombre= leer.next();
		double resultadoNota=0;
		int contador=0;
		for (Alumno alumno: listaAlumno) {
			contador++;	
			if (alumno.getNombre().equals(nombre)) {
				for (double nota: alumno.getNotas()) {
					resultadoNota+=nota;
				}
				System.out.println("La nota final fue "+ (resultadoNota/3) );
				return resultadoNota/3;
			}else if (listaAlumno.size()==contador) {
				System.out.println("lo sentimos, no se encontro coincidencia");
			}
		}
		return 0;
	}
	
	public void mostrarDatos() {
		for (Alumno alumno: listaAlumno) {
			System.out.println("Nombre: "+alumno.getNombre());
			for(double nota: alumno.getNotas()) {
				System.out.print("["+nota+"]");
			}
			System.out.println();
		}
	}
	
	
	

}
