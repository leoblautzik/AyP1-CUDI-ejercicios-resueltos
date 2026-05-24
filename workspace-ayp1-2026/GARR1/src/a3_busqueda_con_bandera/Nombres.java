package a3_busqueda_con_bandera;

public class Nombres {

	private String[] nombres;

	public Nombres(String[] nombres) {
		this.nombres = nombres;
	}

	public int buscar(String nombre) {
		int pos = -1;
		boolean encontrado = false;
		for (int j = 0; j < nombres.length && !encontrado; j++) {
			if (this.nombres[j].equals(nombre)) {
				encontrado = true;
				pos = j;
			}
		}
		return pos;
	}

	public static void main(String[] args) {
		String[] frutas = { "manzana", "banana", "naranja", "uva", "pera", "mango" };
		Nombres n = new Nombres(frutas);

		System.out.println(n.buscar("naranja"));
		System.out.println(n.buscar("kiwi"));
	}

}
