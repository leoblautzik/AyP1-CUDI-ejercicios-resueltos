package a2_analizadorDeMatrices;

public class AnalizadorDeMatrices {
	/**
	 * pre: La matris no debe ser nula post: devuelve la cantidad de elementos de
	 * 'matriz' que tengan valor 0.
	 */
	public int contarCeros(double[][] matriz) {
		if (matriz == null) {
			throw new Error("Matriz no puede ser Nula");
		}
		int contador = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == 0) {
					contador++;
				}
			}
		}

		return contador;
	}

	/**
	 * post: devuelve la cantidad de elementos de 'matriz' cuyo valor
	 *       esté en el rango ['desde', 'hasta'].
	 */
	public int contarElementosEnElRango(double[][] matriz, double desde, double hasta) {
		int contador = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] >= desde && matriz[i][j] <= hasta) {
					contador++;
				}
			}
		}
		
		return contador;
	}

	public static void main(String[] args) {

	}
}
