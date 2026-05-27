package c1_codificacionRun_Length;

import java.util.Arrays;

public class RunLength {

	public int[] comprimir(int[] valores) {

		if (valores.length == 0)
			return new int[] {};

		// necesitamos saber la cantidad de valores distintos
		int valorActual = valores[0];
		int cantValoresDistintos = 1;
		for (int i = 1; i < valores.length; i++) {
			if (valores[i] != valorActual) {
				cantValoresDistintos++;
				valorActual = valores[i];
			}
		}
		int[] comprimido = new int[cantValoresDistintos * 2];
		int j = 0;

		int cantRepeticiones = 1;
		for (int i = 0; i < valores.length; i++) {
			if ( i < valores.length - 1 && valores[i] == valores[i + 1]) {
				cantRepeticiones++;
			} else {
				comprimido[j++] = valores[i];
				comprimido[j++] = cantRepeticiones;
				cantRepeticiones = 1;
			}
		}

		return comprimido;
	}

	public int[] descomprimir(int[] comprimido) {

		if (comprimido.length == 0)
			return new int[] {};

		// calculamos el tamaño total del arreglo descomprimido.
		int tamanio = 0;
		for (int i = 1; i < comprimido.length; i += 2) {
			tamanio += comprimido[i];
		}

		int[] descomprimido = new int[tamanio];
		int j = 0;

		for (int i = 0; i < comprimido.length; i += 2) {
			int valor = comprimido[i];
			int repeticiones = comprimido[i + 1];
			for (int k = 0; k < repeticiones; k++) {
				descomprimido[j++] = valor;
			}
		}

		return descomprimido;
	}

	public static void main(String[] args) {

		// int[] original = { 5, 5, 5, 2, 2, 8, 8, 8, 8, 1, 1, 1 };
		// int[] original = { 5 };
		int[] original = { };
		System.out.println("Original:\t" + Arrays.toString(original));

		RunLength rl = new RunLength();

		int[] comprimido = rl.comprimir(original);
		System.out.println("Comprimido:\t" + Arrays.toString(comprimido));

		int[] descomprimido = rl.descomprimir(comprimido);
		System.out.println("Descomprimido:\t" + Arrays.toString(descomprimido));

	}

}
