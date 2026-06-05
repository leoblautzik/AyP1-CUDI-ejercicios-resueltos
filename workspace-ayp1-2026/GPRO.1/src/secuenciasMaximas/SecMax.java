package secuenciasMaximas;

public class SecMax {

	private int[] valores;

	public SecMax(int[] valores) {
		this.valores = valores;
	}

	/**
	 * pos: cuenta cuántos valores válidos se han recibido
	 */
	public int cuantosValoresValidos() {
		int contadorDeValoresValidos = 0;

		for (int i = 0; i < this.valores.length; i++) {
			if (esValido(this.valores[i]))
				contadorDeValoresValidos++;
		}

		return contadorDeValoresValidos;
	}

	private boolean esValido(int x) {
		return x % 2 != 0 && x % 3 != 0 && x % 5 != 0;
	}

	/**
	 * pos: retorna la longitud de la o las secuencias más largas de valores válidos
	 * consecutivos.
	 */
	public int longitudSecuenciaMaxima() {
		int longitudDeLaSecMAx = 0;
		int longitudSecActual = 0;
		for (int i = 0; i < this.valores.length; i++) {
			if (esValido(this.valores[i])) {
				longitudSecActual++;
			} else {
				if (longitudSecActual > longitudDeLaSecMAx)
					longitudDeLaSecMAx = longitudSecActual;
				longitudSecActual = 0;
			}
		}
		
		if (longitudSecActual > longitudDeLaSecMAx)
			longitudDeLaSecMAx = longitudSecActual;

		return longitudDeLaSecMAx;
	}

}
