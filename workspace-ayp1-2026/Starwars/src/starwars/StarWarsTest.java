package starwars;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

	/**
	 * Verifica que la composición cruzada Nave <-> Piloto se mantenga siempre
	 * consistente en ambos sentidos, sin importar por qué método se dispare
	 * la asignación o la baja.
	 */
	public class StarWarsTest {

		private Nave xwing;
		private Piloto luke;

		@BeforeEach
		void setUp() {
			xwing = new Nave("X-Wing");
			luke = new Piloto("Luke Skywalker");
		}

		// --- Invariante básica ---------------------------------------------

		@Test
		void alAsignarDesdeLaNave_amboLadosQuedanConsistentes() {
			xwing.asignarPiloto(luke);

			assertTrue(piloteaLaNave(luke, xwing), "El piloto debería reconocer que está en esa nave");
			assertTrue(naveTieneEstePiloto(xwing, luke), "La nave debería reconocer a ese piloto");
		}

		@Test
		void llamarSoloSubirseNave_dejaLaRelacionAsimetrica() {
			luke.subirseNave(xwing);

			assertTrue(piloteaLaNave(luke, xwing), "El piloto sí queda referenciando la nave");
			assertTrue(naveTieneEstePiloto(xwing, luke),
					"La nave se entera aunque solo se llama subirseNave() directamente");
		}

		// --- Casos de "trampa" (setters crudos o llamadas parciales) --------

		@Test
		void noDeberiaPermitirQueUnPilotoQuedeEnDosNavesALaVez() {
			Nave tieFighter = new Nave("TIE Fighter");

			luke.subirseNave(xwing);

			assertThrows(Error.class, () -> luke.subirseNave(tieFighter),
					"subirseNave debería rechazar una segunda nave si ya tiene una asignada");
		}

		@Test
		void noDeberiaPermitirQueUnaNaveTengaDosPilotosALaVez() {
			Piloto han = new Piloto("Han Solo");

			xwing.asignarPiloto(luke);

			assertThrows(Error.class, () -> xwing.asignarPiloto(han),
					"asignarPiloto debería rechazar un segundo piloto si ya hay uno asignado");
		}

		@Test
		void bajarPilotoDesdeLaNave_debeLimpiarAmbosLados() {
			xwing.asignarPiloto(luke);
			xwing.bajarPiloto();

			assertFalse(piloteaLaNave(luke, xwing), "El piloto no debería seguir referenciando la nave");
			assertFalse(naveTieneEstePiloto(xwing, luke), "La nave no debería seguir referenciando al piloto");
		}

		@Test
		void bajarseNaveDesdeElPiloto_debeLimpiarAmbosLados() {
			xwing.asignarPiloto(luke);
			luke.bajarseNave();

			assertFalse(piloteaLaNave(luke, xwing), "El piloto no debería seguir referenciando la nave");
			assertFalse(naveTieneEstePiloto(xwing, luke), "La nave no debería seguir referenciando al piloto");
		}

		@Test
		void reasignarDespuesDeBajar_debeFuncionarSinErrores() {
			xwing.asignarPiloto(luke);
			xwing.bajarPiloto();

			Piloto han = new Piloto("Han Solo");
			assertDoesNotThrow(() -> xwing.asignarPiloto(han));
			assertTrue(naveTieneEstePiloto(xwing, han));
		}

		// --- Helpers basados solo en la interfaz pública ---------------------
		// (No se usa reflection a propósito: si alguien agrega un setter crudo
		// que rompe la invariante, estos helpers, basados en toString()/getters
		// públicos, deberían detectarlo igual.)

		private boolean piloteaLaNave(Piloto p, Nave n) {
			return p.toString().contains(n.getModelo());
		}

		private boolean naveTieneEstePiloto(Nave n, Piloto p) {
			return n.toString().contains(p.getNombre());
		}
	}
	


