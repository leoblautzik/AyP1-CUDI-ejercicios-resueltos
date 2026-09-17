package starwars;

public class Nave {

	private String modelo;
	private Piloto piloto;

	public Nave(String modelo) {
		this.modelo = modelo;
		this.piloto = null;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void asignarPiloto(Piloto piloto) {
		if (this.piloto != null) {
			throw new Error("Ya hay piloto asignado");
		}
		this.piloto = piloto;
		if (!piloto.tieneNaveAsignada())
			piloto.subirseNave(this);
	}

	public void bajarPiloto() {
		if (this.piloto != null) {
			Piloto aux = this.piloto;
			this.piloto = null;
			aux.bajarseNave();
		}
	}

	public boolean tienePilotoAsignado() {
		return this.piloto != null;
	}

	@Override
	public String toString() {
		if (this.piloto == null)
			return "Nave [modelo=" + modelo + ", piloto=" + "Sin piloto asignado" + "]";
		return "Nave [modelo=" + modelo + ", piloto=" + piloto.getNombre() + "]";
	}

}
