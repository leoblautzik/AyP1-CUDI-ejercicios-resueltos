package a2_acumulador;
/*Dado un arreglo de notas enteras, calculá la suma total y el promedio. Mostrá si el promedio es promoción (>= 7.0).

int[] notas = {7, 5, 8, 4, 9, 6, 5};
Tareas:

Recorrelo con un for clásico y acumulá la suma en una variable entera.
Calculá el promedio como double. (Atención: división entera vs. decimal)
Imprimí suma, promedio y si aprueba.
Bonus: repetilo con for-each y verificá que el resultado es idéntico.
Cuidado con (double) suma / notas.length vs suma / notas.length. Probá ambas formas y observá la diferencia.
*/

public class Acumulador {

	public static void main(String[] args) {
		int suma = 0;
		int sumaForeach = 0;
		double promedio;

		int[] notas = { 7, 5, 8, 4, 9, 6, 5 };

		for (int i = 0; i < notas.length; i++) {
			suma += notas[i];
		}
		
		for (int cadaNota : notas) {
			sumaForeach += cadaNota;			
		}

		if (notas.length > 0) {
			promedio = (double)suma / notas.length;
			System.out.printf("%.1f\n",promedio);
			System.out.println(promedio);
		} else {
			System.out.println("No hay notas");

		}

	}

}
