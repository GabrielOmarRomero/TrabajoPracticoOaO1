package modelo;

public class Asistidor {

	private Jugador jugador;
	private int asistencias;
	
	public Asistidor(Jugador jugador, int asistencias) {
		super();
		this.jugador = jugador;
		this.asistencias = asistencias;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public int getAsistencias() {
		return asistencias;
	}
	
	@Override
	public String toString() {
		return "Jugador: " + jugador.getApellido() + ", " + jugador.getNombre() + " | DNI: " + jugador.getDni() + " | Goles: " + asistencias + "\n"; 
	}
	
}
