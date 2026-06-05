package computandoPatentes;

public class ComputandoPatentes {

	public Patente siguientePatente(Patente p) {
		boolean acarreo = true;
		String siguiente = "";
		int formato = p.getNumeroDePatente().length();
		char[] patente = p.getNumeroDePatente().toCharArray();
		//patente[3];
		//patente.charAt(3);
		
		for (int i = formato - 1; i >= 0; i--) {
			if (acarreo) {
				siguiente = this.letraSiguiente(patente[i]) + siguiente;
				if (patente[i] == 'Z' || patente[i] == '9')
					acarreo = true;
				else
					acarreo = false;
			} else
				siguiente = patente[i] + siguiente;
		}
		return new Patente(siguiente);
	}

	private char letraSiguiente(char c) {
		if (c == 'Z')
			return 'A';
		if (c == '9')
			return '0';
		return (char) (c + 1);
	}

}
