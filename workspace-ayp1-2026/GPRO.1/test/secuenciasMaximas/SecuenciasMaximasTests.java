package secuenciasMaximas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SecuenciasMaximasTests {

	@Test
	void ejemploCuantosValoresTest() {
		int v[] = {9, 7, 11, 6, 14, 19, 5, 11, 17, 18};
		SecMax sm = new SecMax(v);
		assertEquals(5, sm.cuantosValoresValidos());
		
	}
	
	@Test
	void ejemploLongitudSecMaxTest() {
		int v[] = {9, 7, 11, 6, 14, 19, 5, 11, 17, 18};
		SecMax sm = new SecMax(v);
		assertEquals(2, sm.longitudSecuenciaMaxima());
		
	}
	
	@Test
	void todosValidosTest() {
		int v[] = {7, 11, 19, 11, 17};
		SecMax sm = new SecMax(v);
		assertEquals(5, sm.longitudSecuenciaMaxima());
		
	}
	
	@Test
	void todosInValidosTest() {
		int v[] = {2,3,5,6,9,10,15,6,70};
		SecMax sm = new SecMax(v);
		assertEquals(0, sm.longitudSecuenciaMaxima());
		assertEquals(0, sm.cuantosValoresValidos());
		
	}
	
	@Test
	void sinDatosTest() {
		int v[] = {};
		SecMax sm = new SecMax(v);
		assertEquals(0, sm.longitudSecuenciaMaxima());
		assertEquals(0, sm.cuantosValoresValidos());
		
	}

}
