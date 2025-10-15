package modelo;

public class Goleador {

	private Jugador jugador;
	private int goles;
	
	public Goleador(Jugador jugador, int goles) {
		super();
		this.jugador = jugador;
		this.goles = goles;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public int getGoles() {
		return goles;
	}
	
	@Override
	public String toString() {
		return "Jugador: " + jugador.getApellido() + ", " + jugador.getNombre() + " | DNI: " + jugador.getDni() + " | Goles: " + goles + "\n"; 
	}
	
}
