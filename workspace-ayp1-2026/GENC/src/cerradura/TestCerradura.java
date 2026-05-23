package cerradura;

public class TestCerradura {

	public static void main(String[] args) {
		Cerradura titan = new Cerradura(1111, 3);
		titan.cerrar();
		titan.abrir(1232);
		titan.abrir(1222);
		titan.abrir(1111);
		System.out.println(titan.estaAbierta());

		Cerradura trabex = new Cerradura(1234, 2);
		trabex.cerrar();
		trabex.abrir(1232);
		trabex.abrir(1222);
		trabex.abrir(1233);
				
	}

}
