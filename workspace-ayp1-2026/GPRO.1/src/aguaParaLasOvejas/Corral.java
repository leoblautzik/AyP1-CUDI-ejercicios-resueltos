package aguaParaLasOvejas;

public class Corral {

	private double limiteNorte;
	private double limiteSur;
	private double limiteEste;
	private double limiteOeste;

	public Corral(Punto p1, Punto p2, Punto p3, Punto p4) {
		Punto[] puntos = { p1, p2, p3, p4 };
		setLimiteNorte(puntos);
		setLimiteSur(puntos);
		setLimiteEste(puntos);
		setLimiteOeste(puntos);
		
		//Defino las esquinas de un rectángulo
		Punto[] esquinas = { new Punto(this.limiteNorte, this.limiteOeste), new Punto(this.limiteSur, this.limiteEste),
				new Punto(this.limiteNorte, this.limiteEste), new Punto(this.limiteSur, this.limiteOeste) };
		
		// Verifico que los puntos sean esquinas de un rectángulo
		for (int i = 0; i < puntos.length; i++) {
			if (!contains(puntos[i], esquinas))
				throw new Error("Los puntos no forman rectangulo");
		}
	}

	public int cuantasBebidasAdentro(Punto[] bebidas) {
		int contadorDeBebidasAdentro = 0;

		for (int i = 0; i < bebidas.length; i++) {
			if (bebidas[i].getX() >= limiteSur && bebidas[i].getX() <= limiteNorte && bebidas[i].getY() >= limiteOeste
					&& bebidas[i].getY() <= limiteEste)
				contadorDeBebidasAdentro++;
		}
		return contadorDeBebidasAdentro;
	}

	private boolean contains(Punto p, Punto[] esquinas) {
		int j = 0;
		boolean encontrado = false;
		while (j < esquinas.length && !encontrado) {
			encontrado = p.equals(esquinas[j]);
			j++;
		}
		return encontrado;
	}

	private void setLimiteNorte(Punto[] puntos) {
		this.limiteNorte = puntos[0].getX();
		for (int i = 1; i < puntos.length; i++) {
			if (puntos[i].getX() > this.limiteNorte)
				this.limiteNorte = puntos[i].getX();
		}
	}

	private void setLimiteSur(Punto[] puntos) {
		this.limiteSur = puntos[0].getX();
		for (int i = 1; i < puntos.length; i++) {
			if (puntos[i].getX() < this.limiteSur)
				this.limiteSur = puntos[i].getX();
		}
	}

	private void setLimiteEste(Punto[] puntos) {
		this.limiteEste = puntos[0].getY();
		for (int i = 1; i < puntos.length; i++) {
			if (puntos[i].getY() > this.limiteEste)
				this.limiteEste = puntos[i].getY();
		}
	}

	private void setLimiteOeste(Punto[] puntos) {
		this.limiteOeste = puntos[0].getY();
		for (int i = 1; i < puntos.length; i++) {
			if (puntos[i].getY() < this.limiteOeste)
				this.limiteOeste = puntos[i].getY();
		}
	}

}
