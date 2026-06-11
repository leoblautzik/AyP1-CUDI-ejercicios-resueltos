package a2_analizadorDeMatrices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAnalizadorDeMatrices {

	@Test
	void caso1Enunciado() {
		double[][] m1 = { { 5.0, 3.5, 2.4 }, { 2.1, -9.2, 5.1 }, { 2.3, 7.9, -2.3 }, { 1.0, 6.1, -8.5 } };
		AnalizadorDeMatrices am = new AnalizadorDeMatrices();
		int esperado = 0;
		int obtenido = am.contarCeros(m1);
		assertEquals(esperado, obtenido);
	}

	@Test
	void caso2Enunciado() {

		double[][] m2 = { { 2.0, 0.0, 3.4, 0.0 }, { 0.0, 5.7, -2.3, 9.8 } };

		AnalizadorDeMatrices am = new AnalizadorDeMatrices();
		int esperado = 3;
		int obtenido = am.contarCeros(m2);
		assertEquals(esperado, obtenido);
	}

	@Test
	void casoEnunciado() {

		double[][] m3 = { { 1.6 } };

		AnalizadorDeMatrices am = new AnalizadorDeMatrices();
		int esperado = 0;
		int obtenido = am.contarCeros(m3);
		assertEquals(esperado, obtenido);
	}

	@Test
	void casoMatrizConUnaSolaFilaVacia() {

		double[][] m4 = { {} };

		AnalizadorDeMatrices am = new AnalizadorDeMatrices();
		int esperado = 0;
		int obtenido = am.contarCeros(m4);
		assertEquals(esperado, obtenido);
	}

	@Test
	void casoMatrizVacia() {

		double[][] m5 = {};

		AnalizadorDeMatrices am = new AnalizadorDeMatrices();
		int esperado = 0;
		int obtenido = am.contarCeros(m5);
		assertEquals(esperado, obtenido);
	}

	@Test
	void noAceptaUnaMatrizNula() {
		double[][] m = null;
		AnalizadorDeMatrices am = new AnalizadorDeMatrices();
		assertThrows(Error.class, () -> am.contarCeros(m));
	}

}
