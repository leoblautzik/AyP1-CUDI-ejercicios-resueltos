package filaDeEscolares;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FilaDeEscolaresTest {

	@Test
	void cantidadDeAlumnosTest() {
		int [] escolares = {72, 67, 103, 69, 79, 123, 141, 66, 79, 112, 174, 90};
		FilaDeEscolares fde = new FilaDeEscolares(escolares);
		assertEquals(12, fde.cantidadDeAlumnos());
	}
	
	@Test
	void masAltoTest() {
		int [] escolares = {72, 67, 103, 69, 79, 123, 141, 66, 79, 112, 174, 90};
		FilaDeEscolares fde = new FilaDeEscolares(escolares);
		assertEquals(174, fde.alturaDelMasAlto());
	}
	
	@Test
	void masBajoTest() {
		int [] escolares = {72, 67, 103, 69, 79, 123, 141, 66, 79, 112, 174, 90};
		FilaDeEscolares fde = new FilaDeEscolares(escolares);
		assertEquals(66, fde.alturaDelMasBajo());
	}
	
	@Test
	void ubicacionDeLosmasBajosTest() {
		int [] escolares = {72, 66, 103, 69, 79, 123, 141, 66, 79, 112, 174, 90};
		FilaDeEscolares fde = new FilaDeEscolares(escolares);
		int [] esperado = {2, 8};
		assertArrayEquals(esperado, fde.ubicaciónDelosMasBajos());
	}
	
	@Test
	void mayorDifDeAlturasConsecutivasTest() {
		int [] escolares = {72, 67, 103, 69, 79, 123, 141, 66, 79, 112, 174, 90};
		FilaDeEscolares fde = new FilaDeEscolares(escolares);
		assertEquals(84, fde.mayorDiferenciaDeAlturas());
	}
	
	@Test
	void promedioDeAlturasTest() {
		int [] escolares = {72, 67, 103, 69, 79, 123, 141, 66, 79, 112, 174, 90};
		FilaDeEscolares fde = new FilaDeEscolares(escolares);
		assertEquals(97, fde.promedioDeLAsAlturas());
	}

}
