package modelo;

import java.time.LocalTime;

public class Registro {

	public int idRegistro;
	public Jugador jugador;
	public int goles;
	public int asistencias;
	public LocalTime minutosJugados;
	public Partido partido;
	
	public Registro(int idRegistro, Jugador jugador, int goles, int asistencias, LocalTime minutosJugados,
			Partido partido) {
		super();
		this.idRegistro = idRegistro;
		this.jugador = jugador;
		this.goles = goles;
		this.asistencias = asistencias;
		this.minutosJugados = minutosJugados;
		this.partido = partido;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public LocalTime getMinutosJugados() {
		return minutosJugados;
	}

	public void setMinutosJugados(LocalTime minutosJugados) {
		this.minutosJugados = minutosJugados;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public int getIdRegistro() {
		return idRegistro;
	}
	
	@Override
	public String toString() {
		return 	"ID: " + idRegistro + "\n"+
				"-----Jugador-----" + "\n" + jugador + "\n"+
				"CANTIDAD DE GOLES-->" + goles + "\n"+
				"CANTIDAD DE ASISTENCIAS-->" + asistencias + "\n"+
				"TIEMPO DE JUEGO: " + minutosJugados + "\n"+
				"-----Partido-----" + partido + "\n"
				;
	}
	
	
	
	
}
