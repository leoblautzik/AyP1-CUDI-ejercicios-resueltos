package b2_depuracionRegistroSismico;

import java.util.Arrays;

public class RegistroSismico {

	private int[] lecturas;
	private int lecturasInvalidas = 0;

	public RegistroSismico(int[] lecturas) {
		this.lecturas = lecturas;
	}

	private int[] depurarLecturas() {
		int tamanio = 0;
		int j = 0;
		int[] lecturasValidas;
		for (int lectura : lecturas) {
			if (lectura != 0) {
				tamanio++;
			} else
				lecturasInvalidas++;
		}

		lecturasValidas = new int[tamanio];
		for (int lectura : lecturas) {
			if (lectura != 0) {
				lecturasValidas[j] = lectura;
				j++;
			}
		}

		return lecturasValidas;
	}

	public int[] getLecturas() {
		return this.lecturas;
	}

	public int[] getLecturasValidas() {
		return this.depurarLecturas();
	}

	public int getCuantasLecturasInvalidas() {
		return this.lecturasInvalidas;
	}

	public static void main(String[] args) {

		int[] lecturas = { 4, 0, 7, 0, 0, 3, 9, 0, 2, 6, 0, 1 };

		RegistroSismico rs = new RegistroSismico(lecturas);

		System.out.println("Lecturas: " + Arrays.toString(rs.getLecturas()));
		System.out.println("Lecturas validas: " + Arrays.toString(rs.getLecturasValidas()));
		System.out.println("Lecturas invalidas: " + rs.getCuantasLecturasInvalidas());

	}
}
