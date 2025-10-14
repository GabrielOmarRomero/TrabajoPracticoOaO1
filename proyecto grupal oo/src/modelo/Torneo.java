package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Torneo {
	
	private int idTorneo;
    private String nombre;
    private String temporada;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Equipo> equipos;
    private List<Partido> lstPartidos;
    
	public Torneo(int idTorneo, String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {
		super();
		this.idTorneo = idTorneo;
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.equipos = new ArrayList<>();
		this.lstPartidos = new ArrayList<>();
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

	public List<Partido> getLstPartidos() {
		return lstPartidos;
	}

	@Override
	public String toString() {
    	return 	"ID: " + idTorneo + "\n" +
    			"Torneo: " + nombre + "\n" +
    			"Temporada: " + temporada + "\n" +
    			"Inicio: " + fechaInicio + "\n" +
    			"Fin: " + fechaFin + "\n" +
    			"------Equipos Participantes------" + "\n" + equipos + "\n" + 
    			"------Partidos------" + "\n" + lstPartidos + "\n";
	}
	
	//--------------------------PARTIDO-----------------------------------------
	
	public Partido traerPartido(int id) {
		
		Partido partido=null;
		int i=0;
		
		while(i<lstPartidos.size() && partido==null) {
			if(lstPartidos.get(i).getIdPartido()==id) {
				partido=lstPartidos.get(i);
			}
			i++;
		}
		
		return partido;
		
	}
	
	public boolean agregarPartido(LocalDateTime fechaHora, int fechaJornada, Equipo local, Equipo visitante, String estadio) {
		
		int id=1;
		if(!lstPartidos.isEmpty()) {
			id=lstPartidos.get(lstPartidos.size()-1).getIdPartido()+1;
		}
		
		return lstPartidos.add(new Partido(id, fechaHora, fechaJornada, local, visitante, estadio));
		
	}
	
	public boolean eliminarPartido(int id) throws Exception {
		
		Partido partido=traerPartido(id);
		if(partido==null) throw new Exception("ERROR: El partido que desea eliminar no existe");
		
		return lstPartidos.remove(partido);
				
	}
	
	public boolean modificarPartido(int id, LocalDateTime fechaHora, int fechaJornada, Equipo local, Equipo visitante, String estadio) throws Exception {
		
		Partido partido=traerPartido(id);
		if(partido==null) throw new Exception("ERROR: El partido que desea modificar no existe");
		
		partido.setFechahora(fechaHora);
		partido.setFechaJornada(fechaJornada);
		partido.setLocal(local);
		partido.setVisitante(visitante);
		partido.setEstadio(estadio);
		return true;
		
	}
	
	//--------------------------EQUIPO------------------------------
	public Equipo traerEquipo(int id) {
		
		Equipo equipo=null;
		int i=0;
		while(i<equipos.size() && equipo==null) {
			if(equipos.get(i).getIdEquipo()==id) {
				equipo=equipos.get(i);
			}
			i++;
		}
		
		return equipo;	
	}
	
	public boolean agregarEquipo(Equipo equipo) throws Exception {
		Equipo equipoAux=traerEquipo(equipo.getIdEquipo());
		if(equipoAux!=null)throw new Exception("ERROR: El equipo ya existe dentro del torneo");
		return equipos.add(equipo);
	}
	
	public boolean eliminarEquipo(int id) throws Exception {
		Equipo equipoAux=traerEquipo(id);
		if(equipoAux==null)throw new Exception("ERROR: El equipo no existe dentro del torneo");
		return equipos.remove(equipoAux);
	}
	
	
}
