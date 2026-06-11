package a1_temperaturas;

import java.util.Arrays;

//1. Imprimí la cantidad de filas y la cantidad de columnas usando .length.
//2. Imprimí la temperatura de la segunda ciudad (fila 1) en el tercer día (columna 2).
//3. Reemplazá la temperatura de la primera ciudad en el último día por 99.9.
//4. Intentá acceder a temps[3][0] y observá qué excepción lanza Java. 
//   ¿En qué momento ocurre: al compilar o al ejecutar?
//5. Recorrelo con un doble for e imprimí todos los valores con el formato 
//   temps[<i>][<j>] = <valor> (Tip: utilizar System.out.printf)

public class Temps {

	public static void main(String[] args) {

		double[][] temps = { 
				{ 22.0, 18.5, 31.0, 27.3 }, 
				{ 15.0, 29.0, 24.1, 20.8 }, 
				{ 30.2, 33.0, 28.7, 25.5 }								
		};

		System.out.println("Cantidad de filas: " + temps.length);
		System.out.println("Cantidad de columnas: " + temps[0].length);
		temps[0][3] = 99.9;
		System.out.println(Arrays.deepToString(temps));
		//System.out.println(temps[3][0]);
		
		temps[0][3] = 27.3;

		System.out.println();

		for (int i = 0; i < temps.length; i++) {
			for (int j = 0; j < temps[i].length; j++) {
				System.out.printf("temps[%d][%d] = %.2f  ", i, j, temps[i][j]);
			}
			System.out.println();
		}

		// 6. Imprimir la ciudad con la temperatura más baja.
		double tempMinima = temps[0][0];
		int ciudadMasFria = 0;
		for (int i = 0; i < temps.length; i++) {
			for (int j = 0; j < temps[i].length; j++) {
				if (temps[i][j] < tempMinima) {
					tempMinima = temps[i][j];
					ciudadMasFria = i;
				}
			}
		}
		System.out.println("La ciudad mas fria es la que esta en la fila " + (ciudadMasFria + 1));

		
		//7. Devolver un array con las temperaturas promedio de cada ciudad.
		double[] tempPromedioPorCiudad = new double[temps.length];
		
		for (int i = 0; i < temps.length; i++) {
			double sumaTemp = 0;
			for (int j = 0; j < temps[i].length; j++) {
				sumaTemp += temps[i][j];
			}
			tempPromedioPorCiudad[i] = sumaTemp / temps[i].length;
		}
		//System.out.println(Arrays.toString(tempPromedioPorCiudad));
		for (int i = 0; i < tempPromedioPorCiudad.length; i++) {
			System.out.printf("Temperatura promedio de la ciudad %d: %.2f\n", i+1, tempPromedioPorCiudad[i]);
		}
	}
}
