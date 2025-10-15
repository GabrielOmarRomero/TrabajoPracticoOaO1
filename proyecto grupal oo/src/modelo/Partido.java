package modelo;

import java.time.LocalDateTime;

public class Partido {
	
	private int idPartido;
    private LocalDateTime fechahora;
    private int fechaJornada;
    private Equipo local;
    private Equipo visitante;
    private String estadio;
    private int golesLocal;
    private int golesVisitante;
    
	public Partido(int idPartido, LocalDateTime fechahora, int fechaJornada, Equipo local, Equipo visitante,
			String estadio) {
		super();
		this.idPartido = idPartido;
		this.fechahora = fechahora;
		this.fechaJornada = fechaJornada;
		this.local = local;
		this.visitante = visitante;
		this.estadio = estadio;
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public LocalDateTime getFechahora() {
		return fechahora;
	}

	public void setFechahora(LocalDateTime fechahora) {
		this.fechahora = fechahora;
	}

	public int getFechaJornada() {
		return fechaJornada;
	}

	public void setFechaJornada(int fechaJornada) {
		this.fechaJornada = fechaJornada;
	}

	public Equipo getLocal() {
		return local;
	}

	public void setLocal(Equipo local) {
		this.local = local;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	
	public int getGolesLocal() {
	    return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
	    this.golesLocal = golesLocal;
	}

	public int getGolesVisitante() {
	    return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
	    this.golesVisitante = golesVisitante;
	}

	@Override
	public String toString() {
		return 	"\n" + "ID: "+ idPartido + "\n" +
				"Fecha y hora del encuentro: " + fechahora + "\n"+ 
				"Fecha de Jornada: " + fechaJornada + "\n"+
				"*****"+ local.getNombre() + " VS " + visitante.getNombre() + "*****" + "\n" + 
				"Estadio: " + estadio + "\n";
	}

}
