package mensajesSecretos;

public class Secreto {

	private String mensajeCodificado;

	public Secreto(String mensajeCodificado) {
		this.mensajeCodificado = mensajeCodificado;
	}

	public String decodificar() {
		String mensajeDecodificado = "";
		String secreto = "";
		int i = 0;
		while (i < this.mensajeCodificado.length()) {
			if (this.mensajeCodificado.charAt(i) == '(') {
				i++;
				while (this.mensajeCodificado.charAt(i) != ')') {
					secreto += this.mensajeCodificado.charAt(i);
					i++;
				}
				secreto = this.invertir(secreto);
				mensajeDecodificado += secreto;
				secreto = "";
			} else {
				mensajeDecodificado += this.mensajeCodificado.charAt(i);
			}
			i++;
		}
		return mensajeDecodificado;
	}

	private String invertir(String s) {
		String invertida = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			invertida += s.charAt(i);
		}
		return invertida;
	}

}
