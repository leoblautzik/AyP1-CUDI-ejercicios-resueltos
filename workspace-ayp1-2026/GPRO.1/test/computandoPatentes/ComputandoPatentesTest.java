package computandoPatentes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComputandoPatentesTest {

	@Test
	void deSeisSoloCambialaUltimaLetraTest() {
		ComputandoPatentes compuPat = new ComputandoPatentes();
		Patente patente = new Patente("ABC123");
		Patente esperado = new Patente("ABC124");
		assertEquals(esperado, compuPat.siguientePatente(patente));
	}
	
	@Test
	void deSeisCambianTodasTest() {
		ComputandoPatentes compuPat = new ComputandoPatentes();
		Patente patente = new Patente("AZZ999");
		Patente esperado = new Patente("BAA000");
		assertEquals(esperado, compuPat.siguientePatente(patente));
	}
	@Test
	void deSieteSoloCambialaUltimaLetraTest() {
		ComputandoPatentes compuPat = new ComputandoPatentes();
		Patente patente = new Patente("AB123AB");
		Patente esperado = new Patente("AB123AC");
		assertEquals(esperado, compuPat.siguientePatente(patente));
	}
	
	@Test
	void deSieteCambianTodasTest() {
		ComputandoPatentes compuPat = new ComputandoPatentes();
		Patente patente = new Patente("AZ999ZZ");
		Patente esperado = new Patente("BA000AA");
		assertEquals(esperado, compuPat.siguientePatente(patente));
	}
	
	@Test
	void errordeSieteTest() {
		ComputandoPatentes compuPat = new ComputandoPatentes();
		Patente patente = new Patente("A9Z99ZZ");
		Patente esperado = new Patente("BA000AA");
		assertEquals(esperado, compuPat.siguientePatente(patente));
	}
	@Test
	void errordeSeisTest() {
		ComputandoPatentes compuPat = new ComputandoPatentes();
		Patente patente = new Patente("A9Z92A");
		Patente esperado = new Patente("BA000AA");
		assertEquals(esperado, compuPat.siguientePatente(patente));
	}

}
