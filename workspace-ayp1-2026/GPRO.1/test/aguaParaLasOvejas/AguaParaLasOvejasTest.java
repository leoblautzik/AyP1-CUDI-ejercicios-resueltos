package aguaParaLasOvejas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AguaParaLasOvejasTest {

	@Test
	void ejemploTest() {
		Corral c = new Corral(new Punto(4, -4), new Punto(4, 7), new Punto(-3, 7), new Punto(-3, -4));

		Punto[] bebidas = { new Punto(-3, -2), new Punto(5, 5), new Punto(2, 3), new Punto(-4, 10), new Punto(0, -7) };
		assertEquals(2, c.cuantasBebidasAdentro(bebidas));
	}

}
