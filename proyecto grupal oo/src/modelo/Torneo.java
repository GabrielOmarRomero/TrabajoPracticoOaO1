package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Torneo {
	
	private int idTorneo;
    private String nombre;
    private String temporada;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Equipo> equipos;
    
	public Torneo(int idTorneo, String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {
		super();
		this.idTorneo = idTorneo;
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.equipos = new ArrayList<>();
	}

	public int getIdTorneo() {
		return idTorneo;
	}

	public void setIdTorneo(int idTorneo) {
		this.idTorneo = idTorneo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	@Override
	public String toString() {
    	return 	"ID: " + idTorneo + "\n" +
    			"Torneo: " + nombre + "\n" +
    			"Temporada: " + temporada + "\n" +
    			"Inicio: " + fechaInicio + "\n" +
    			"Fin: " + fechaFin + "\n" +
    			"------Equipos Participantes------" + "\n" + equipos + "\n";
	}
   	
}
