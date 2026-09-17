package holaMundo;

import java.util.Arrays;
import java.util.Objects;

public class Alumno implements Comparable<Alumno> {
	private int legajo;
	private String apellido;
	private String nombre;
	

	private double promedio;

	public Alumno(int legajo, String apellido, String nombre, double promedio) {
		this.legajo = legajo;
		this.apellido = apellido;
		this.nombre = nombre;
		this.promedio = promedio;
	}
	
	@Override
	public String toString() {
		return "Alumno [legajo=" + legajo + ", apellido=" + apellido + ", nombre=" + nombre + ", promedio=" + promedio
				+ "]";
	}

	public int getLegajo() {
		return legajo;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPromedio() {
		return promedio;
	}

	public void ordenarPorLegajo(Alumno[] alumnos) {

		int n = alumnos.length;

		for (int i = 0; i < n - 1; i++) {
			int posMenor = i;

			// Buscar el menor elemento
			for (int j = i + 1; j < n; j++) {
				if (alumnos[j].getLegajo() < alumnos[posMenor].getLegajo()) {
					posMenor = j;
				}
			}

			// Intercambiar
			Alumno aux = alumnos[i];
			alumnos[i] = alumnos[posMenor];
			alumnos[posMenor] = aux;
		}
	}

	public void ordenarPorPromedioDecreciente(Alumno[] alumnos) {

		int n = alumnos.length;

		for (int i = 0; i < n - 1; i++) {
			int posMayor = i;

			// Buscar el menor elemento
			for (int j = i + 1; j < n; j++) {
				if (alumnos[j].getPromedio() > alumnos[posMayor].getPromedio()) {
					posMayor = j;
				}
			}

			// Intercambiar
			Alumno aux = alumnos[i];
			alumnos[i] = alumnos[posMayor];
			alumnos[posMayor] = aux;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, Integer.valueOf(legajo), nombre, Double.valueOf(promedio));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellido, other.apellido) && legajo == other.legajo
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(promedio) == Double.doubleToLongBits(other.promedio);
	}
	
	
	@Override
	public int compareTo(Alumno otro) {
		if(this.getApellido().compareTo(otro.getApellido()) < 0)
			return -1;
		if(this.getApellido().compareTo(otro.getApellido()) > 0)
			return 1;
		
		return this.getNombre().compareTo(otro.getNombre());
	}
	
	public static void main(String[] args) {
		Alumno[] alumnos = {
			    new Alumno(25, "Pérez", "Juan", 7.8),
			    new Alumno(28, "Pérez", "Juana", 7.8),
			    new Alumno(10, "Gómez", "Ana", 9.1),
			    new Alumno(30, "López", "Carlos", 6.5),
			    new Alumno(5, "Fernández", "María", 8.7),
			    new Alumno(18, "Rodríguez", "Lucía", 7.2)
			};
		
		Arrays.sort(alumnos);
		
		System.out.println(Arrays.toString(alumnos));
	}

}


