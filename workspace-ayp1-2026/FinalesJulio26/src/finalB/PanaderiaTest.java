package finalB;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Casos de prueba para el ejercicio "Panaderia".
 *
 * NOTA IMPORTANTE SOBRE INSTANCIACION:
 * El enunciado no provee constructores para Pan ni para Panaderia (solo
 * getters). Para no atarnos a que cada alumno agregue (o no) un
 * constructor propio, este test crea los objetos y les carga los campos
 * privados por REFLECTION, usando exactamente los nombres de atributo que
 * aparecen en el enunciado:
 *   - Pan.tiempoDeCoccion, Pan.temperaturaIdeal
 *   - Panaderia.panes
 *
 * Si tu implementacion de Pan o Panaderia usa OTROS nombres de atributo,
 * ajusta las constantes NOMBRE_ATRIB_* mas abajo.
 *
 * Requiere JUnit 5 (JUnit Jupiter) agregado al build path del proyecto.
 * En Eclipse: click derecho sobre el proyecto -> Build Path -> Add
 * Libraries... -> JUnit -> JUnit 5.
 */
class PanaderiaTest {

    // Ajustar aca si los nombres de atributos difieren de los del enunciado
    private static final String ATRIB_TIEMPO_COCCION = "tiempoDeCoccion";
    private static final String ATRIB_TEMPERATURA_IDEAL = "temperaturaIdeal";
    private static final String ATRIB_PANES = "panes";

    // ---------- Helpers de instanciacion via reflection ----------

    private Pan crearPan(int tiempoDeCoccion, int temperaturaIdeal) {
        try {
            Pan pan = Pan.class.getDeclaredConstructor().newInstance();
            setearAtributo(pan, ATRIB_TIEMPO_COCCION, tiempoDeCoccion);
            setearAtributo(pan, ATRIB_TEMPERATURA_IDEAL, temperaturaIdeal);
            return pan;
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(
                "No se pudo instanciar Pan via reflection. Verifica que exista "
                + "un constructor sin argumentos y que los nombres de atributo "
                + "coincidan con los configurados en el test.", e);
        }
    }

    private Panaderia crearPanaderia(Pan[][] panes) {
        try {
            Panaderia panaderia = Panaderia.class.getDeclaredConstructor().newInstance();
            setearAtributo(panaderia, ATRIB_PANES, panes);
            return panaderia;
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(
                "No se pudo instanciar Panaderia via reflection. Verifica que "
                + "exista un constructor sin argumentos y que el atributo "
                + "'panes' coincida con el configurado en el test.", e);
        }
    }

    private void setearAtributo(Object objetivo, String nombreAtributo, Object valor)
            throws ReflectiveOperationException {
        Field campo = objetivo.getClass().getDeclaredField(nombreAtributo);
        campo.setAccessible(true);
        campo.set(objetivo, valor);
    }

    // ---------- Fixture comun: la bandeja de ejemplo del enunciado ----------

    private Pan[][] bandejaEjemplo;
    private Panaderia panaderiaEjemplo;

    @BeforeEach
    void setUp() {
        // bandeja 0: (180,35) (200,25) (220,45)
        Pan pan1 = crearPan(35, 180);
        Pan pan2 = crearPan(25, 200);
        Pan pan3 = crearPan(45, 220);
        bandejaEjemplo = new Pan[][] { { pan1, pan2, pan3 } };
        panaderiaEjemplo = crearPanaderia(bandejaEjemplo);
    }

    // ==================== 1. Caso del enunciado (control) ====================

    @Nested
    @DisplayName("Caso base del enunciado")
    class CasoBase {

        @Test
        @DisplayName("Cuenta 1 pan quemado con horno=210, maximo=30")
        void cuentaPanesQuemadosDelEjemplo() {
            int resultado = panaderiaEjemplo.cantidadDePanesQuemadosEnBandeja(0, 210, 30);
            assertEquals(1, resultado);
        }

        @Test
        @DisplayName("Suma 105 minutos de horneado total")
        void sumaTiempoTotalDelEjemplo() {
            int resultado = panaderiaEjemplo.tiempoTotalDeHorneadoEnBandeja(0);
            assertEquals(105, resultado);
        }
    }

    // ==================== 2. Ningun pan quemado ====================

    @Nested
    @DisplayName("Casos sin panes quemados")
    class SinPanesQuemados {

        @Test
        @DisplayName("Temperatura del horno no supera ninguna ideal -> 0 quemados")
        void temperaturaBajaNoQuemaNinguno() {
            // horno=150 <= 180,200,220 -> ningun pan supera su temperatura ideal,
            // aunque los tiempos de coccion sean altisimos
            int resultado = panaderiaEjemplo.cantidadDePanesQuemadosEnBandeja(0, 150, 1);
            assertEquals(0, resultado);
        }

        @Test
        @DisplayName("Tiempo de coccion no supera el maximo -> 0 quemados")
        void tiempoBajoNoQuemaNinguno() {
            Pan[][] bandeja = { { crearPan(5, 100), crearPan(5, 100), crearPan(5, 100) } };
            Panaderia panaderia = crearPanaderia(bandeja);
            // horno=999 supera las 3 temperaturas ideales, pero ningun pan
            // llego al tiempo maximo permitido (1000)
            int resultado = panaderia.cantidadDePanesQuemadosEnBandeja(0, 999, 1000);
            assertEquals(0, resultado);
        }
    }

    // ==================== 3. Todos los panes quemados ====================

    @Test
    @DisplayName("Horno muy caliente y tiempos muy largos -> todos quemados")
    void todosLosPanesQuemados() {
        Pan[][] bandeja = { {
            crearPan(500, 50), crearPan(600, 60), crearPan(700, 70)
        } };
        Panaderia panaderia = crearPanaderia(bandeja);
        int resultado = panaderia.cantidadDePanesQuemadosEnBandeja(0, 900, 10);
        assertEquals(3, resultado);
    }

    // ==================== 4. Casos limite (operadores estrictos) ====================

    @Nested
    @DisplayName("Casos limite: > estricto, no >=")
    class CasosLimite {

        @Test
        @DisplayName("Temperatura ideal == temperatura horno -> NO quemado (no 'supero')")
        void temperaturaIgualNoQuema() {
            Pan[][] bandeja = { { crearPan(1000, 200) } }; // tiempo altisimo, temp igual al horno
            Panaderia panaderia = crearPanaderia(bandeja);
            int resultado = panaderia.cantidadDePanesQuemadosEnBandeja(0, 200, 1);
            assertEquals(0, resultado, "La temperatura debe ser ESTRICTAMENTE superada");
        }

        @Test
        @DisplayName("Tiempo de coccion == tiempo maximo -> NO quemado (no 'mas minutos que')")
        void tiempoIgualNoQuema() {
            Pan[][] bandeja = { { crearPan(30, 1) } }; // temp altisima, tiempo igual al maximo
            Panaderia panaderia = crearPanaderia(bandeja);
            int resultado = panaderia.cantidadDePanesQuemadosEnBandeja(0, 900, 30);
            assertEquals(0, resultado, "El tiempo debe ser ESTRICTAMENTE superado");
        }

        @Test
        @DisplayName("Justo un grado y un minuto por encima de ambos umbrales -> quemado")
        void justoPorEncimaDeAmbosUmbralesQuema() {
            Pan[][] bandeja = { { crearPan(31, 199) } };
            Panaderia panaderia = crearPanaderia(bandeja);
            int resultado = panaderia.cantidadDePanesQuemadosEnBandeja(0, 200, 30);
            assertEquals(1, resultado);
        }
    }

    // ==================== 5. Multiples bandejas / indexacion ====================

    @Nested
    @DisplayName("Multiples bandejas e indexacion")
    class MultiplesBandejas {

        @Test
        @DisplayName("Cada bandeja se evalua de forma independiente")
        void bandejasIndependientes() {
            Pan[][] bandejas = {
                { crearPan(50, 100) },              // bandeja 0: se quema con horno alto/tiempo alto
                { crearPan(1, 100) }                // bandeja 1: tiempo bajisimo, no se quema
            };
            Panaderia panaderia = crearPanaderia(bandejas);

            assertEquals(1, panaderia.cantidadDePanesQuemadosEnBandeja(0, 500, 10));
            assertEquals(0, panaderia.cantidadDePanesQuemadosEnBandeja(1, 500, 10));
        }

        @Test
        @DisplayName("Bandeja de un solo pan")
        void bandejaDeUnSoloPan() {
            Pan[][] bandeja = { { crearPan(40, 180) } };
            Panaderia panaderia = crearPanaderia(bandeja);

            assertEquals(1, panaderia.cantidadDePanesQuemadosEnBandeja(0, 200, 30));
            assertEquals(40, panaderia.tiempoTotalDeHorneadoEnBandeja(0));
        }
    }

    // ==================== 6. tiempoTotalDeHorneadoEnBandeja ====================

    @Nested
    @DisplayName("Tiempo total de horneado")
    class TiempoTotal {

        @Test
        @DisplayName("Todos los tiempos en cero -> total 0")
        void todosEnCero() {
            Pan[][] bandeja = { { crearPan(0, 180), crearPan(0, 200), crearPan(0, 220) } };
            Panaderia panaderia = crearPanaderia(bandeja);
            assertEquals(0, panaderia.tiempoTotalDeHorneadoEnBandeja(0));
        }

        @Test
        @DisplayName("Suma correcta con varios panes")
        void sumaConVariosPanes() {
            Pan[][] bandeja = { {
                crearPan(10, 100), crearPan(20, 110), crearPan(30, 120),
                crearPan(5, 130), crearPan(15, 140)
            } };
            Panaderia panaderia = crearPanaderia(bandeja);
            assertEquals(80, panaderia.tiempoTotalDeHorneadoEnBandeja(0));
        }

        @Test
        @DisplayName("No depende de horno ni tiempo maximo (no recibe esos parametros)")
        void noRequiereParametrosDeHorno() {
            // Si compila con la firma del enunciado (sin esos parametros),
            // este test simplemente confirma que el calculo no lanza error
            // por parametros que no existen para este metodo.
            assertDoesNotThrow(() -> panaderiaEjemplo.tiempoTotalDeHorneadoEnBandeja(0));
        }
    }

    // ==================== 7. Ruptura de contrato ====================

    @Nested
    @DisplayName("Contrato: temperatura y tiempo maximo deben ser positivos")
    class RupturaDeContrato {

        @Test
        @DisplayName("temperaturaDelHorno = 0 -> Error")
        void temperaturaCeroLanzaError() {
            assertThrows(Error.class,
                () -> panaderiaEjemplo.cantidadDePanesQuemadosEnBandeja(0, 0, 30));
        }

        @Test
        @DisplayName("temperaturaDelHorno negativa -> Error")
        void temperaturaNegativaLanzaError() {
            assertThrows(Error.class,
                () -> panaderiaEjemplo.cantidadDePanesQuemadosEnBandeja(0, -50, 30));
        }

        @Test
        @DisplayName("tiempoMaximoPermitido = 0 -> Error")
        void tiempoMaximoCeroLanzaError() {
            assertThrows(Error.class,
                () -> panaderiaEjemplo.cantidadDePanesQuemadosEnBandeja(0, 210, 0));
        }

        @Test
        @DisplayName("tiempoMaximoPermitido negativo -> Error")
        void tiempoMaximoNegativoLanzaError() {
            assertThrows(Error.class,
                () -> panaderiaEjemplo.cantidadDePanesQuemadosEnBandeja(0, 210, -10));
        }

        @Test
        @DisplayName("Ambos parametros invalidos a la vez -> Error")
        void ambosParametrosInvalidosLanzanError() {
            assertThrows(Error.class,
                () -> panaderiaEjemplo.cantidadDePanesQuemadosEnBandeja(0, -5, -5));
        }

        @Test
        @DisplayName("Valores minimos validos (1, 1) NO deben lanzar Error")
        void valoresMinimosValidosNoLanzanError() {
            assertDoesNotThrow(
                () -> panaderiaEjemplo.cantidadDePanesQuemadosEnBandeja(0, 1, 1));
        }
    }
}