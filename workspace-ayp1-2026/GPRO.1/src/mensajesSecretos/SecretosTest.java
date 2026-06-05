package mensajesSecretos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SecretosTest {

	@Test
	void ejemploTest() {
		Secreto s = new Secreto("Hoy (.sh 22 sal a) (ed asac ne sominuer son) Marcelo");
		assertEquals("Hoy a las 22 hs. nos reunimos en casa de Marcelo", s.decodificar());
	
	}
	
	@Test
	void todoSecretoTest() {
		Secreto s = new Secreto("(olecraM ed asac ne sominuer son .sh 22 sal a yoH)");
		assertEquals("Hoy a las 22 hs. nos reunimos en casa de Marcelo", s.decodificar());
	}
	
	@Test
	void variosSecretosTest() {
		Secreto s = new Secreto("Hoy a (sal) 22 hs. (son) reunimos en casa de Marcelo()");
		assertEquals("Hoy a las 22 hs. nos reunimos en casa de Marcelo", s.decodificar());
	}
	
	@Test
	void mensajeVacioTest() {
		Secreto s = new Secreto("");
		assertEquals("", s.decodificar());
	}
	
	@Test
	void secretoVacioTest() {
		Secreto s = new Secreto("Hola() (omoc) estas");
		assertEquals("Hola como estas", s.decodificar());
	}

}
