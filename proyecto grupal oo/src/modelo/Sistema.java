package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	
	private List<Entrenador> lstEntrenadores;
	private List<Jugador> lstJugadores;
	private List<Equipo> lstEquipos;
	private List<Torneo> lstTorneos;
	private List<Registro> lstRegistros;
	
	public Sistema() {
		super();
		this.lstEntrenadores = new ArrayList<>();
		this.lstJugadores = new ArrayList<>();
		this.lstEquipos = new ArrayList<>();
		this.lstTorneos = new ArrayList<>();
		this.lstRegistros = new ArrayList<>();
	}

	public List<Entrenador> getLstEntrenadores() {
		return lstEntrenadores;
	}

	public List<Jugador> getLstJugadores() {
		return lstJugadores;
	}

	public List<Equipo> getLstEquipos() {
		return lstEquipos;
	}

	public List<Torneo> getLstTorneos() {
		return lstTorneos;
	}
	
	public List<Registro> getLstRegistros() {
		return lstRegistros;
	}

	//----------------------------------------------------ENTRENADOR-----------------------------------------------------------------	
	public Entrenador traerEntrenador(long dniEntrenador) {
		
		Entrenador entrenador = null;
		int i=0;
		while(i<lstEntrenadores.size() && entrenador==null) {
			if(lstEntrenadores.get(i).getDni()==dniEntrenador) {
				entrenador=lstEntrenadores.get(i);
			}
			i++;
		}
		return entrenador;
		
	}
	
	public boolean agregarEntrenador(String nombre, String apellido, long dni, LocalDate fechaNacimiento, String estrategiaFav) throws Exception {
		
		Entrenador entrenador=traerEntrenador(dni);
		if(entrenador!=null) throw new Exception("ERROR: El entrenador que desea agregar ya existe");
		
		int id=1;
		if(!lstEntrenadores.isEmpty()) {
			id=lstEntrenadores.get(lstEntrenadores.size()-1).getId()+1;
		}
		
		return lstEntrenadores.add(new Entrenador(id, nombre, apellido, dni, fechaNacimiento, estrategiaFav));
		
	}
	
	
	
	public boolean eliminarEntrenador(long dni) throws Exception {
		
		Entrenador entrenadorAux = traerEntrenador(dni); 
		if(entrenadorAux==null) throw new Exception("ERROR: El entrenador que desea eliminar no existe");
		
		int i=0;
		boolean encontrado=false;
		
		while(i<lstEquipos.size() && encontrado==false) {
			if(lstEquipos.get(i).getEntrenador().getDni()==dni) {
				encontrado=true;
			}
			i++;
		}
		
		if(encontrado==true)throw new Exception("ERROR: El entrenador tiene un equipo asignado");
		
		return lstEntrenadores.remove(entrenadorAux);
		
	}
	
	
	public boolean modificarEntrenador(String nombre, String apellido, long dni, LocalDate fechaNacimiento, String estrategiaFav) throws Exception {
		Entrenador entrenador = traerEntrenador(dni);
		if(entrenador==null) throw new Exception("ERROR: El entrenador que desea modificar no existe");
		
		entrenador.setNombre(nombre);
		entrenador.setApellido(apellido);
		entrenador.setDni(dni);
		entrenador.setFechaNacimiento(fechaNacimiento);
		entrenador.setEstrategiaFavorita(estrategiaFav);
		return true;
		
	}
	
	
	//----------------------------------------------------JUGADOR-----------------------------------------------------------------
	public Jugador traerJugador(long dni) {
		Jugador jugador = null;
		int i=0;
		while(i<lstJugadores.size() && jugador==null) {
			if(lstJugadores.get(i).getDni()==dni) {
				jugador=lstJugadores.get(i);
			}
			i++;
		}
		return jugador;
	}
	
	public boolean agregarJugador(String nombre, String apellido, long dni, LocalDate fechaNacimiento, double estatura, double peso, String posicion, int numeroCamiseta) throws Exception {
		
		Jugador jugador = traerJugador(dni);
		
		if(jugador!=null) throw new Exception("ERROR: El jugador que desea agregar ya existe");
		
		int id = 1;
		if(!lstJugadores.isEmpty()) {
			id = lstJugadores.get(lstJugadores.size()-1).getId()+1;
		}
		
		return lstJugadores.add(new Jugador(id, nombre, apellido, dni, fechaNacimiento, estatura, peso, posicion, numeroCamiseta));
		
	}
	
	
	
	public boolean eliminarJugador(long dni) throws Exception {
			
		Jugador jugadorAux= traerJugador(dni);
		if(jugadorAux==null) throw new Exception("ERROR: El jugador que desea eliminar no existe");
		
		int i=0;
		int j=0;
		boolean encontrado=false;
		
		while(i<lstEquipos.size() && encontrado==false) {
			while(j<lstEquipos.get(i).getJugadores().size() && encontrado==false) {
				if(lstEquipos.get(i).getJugadores().get(j).getDni()==dni) {
					encontrado=true;
				}
				j++;
			}
			i++;
		}
		
		if(encontrado==true)throw new Exception("ERROR: El jugador tiene un equipo asignado");
		
		return lstJugadores.remove(jugadorAux);
		
	}
	
    
	public boolean modificarJugador(String nombre, String apellido, long dni, LocalDate fechaNacimiento, double estatura, double peso, String posicion, int numeroCamiseta) throws Exception {
		
		Jugador jugador = traerJugador(dni);
		if(jugador==null)throw new Exception("ERROR: El jugador que desea modificar no existe");
		
		jugador.setNombre(nombre);
		jugador.setApellido(apellido);
		jugador.setDni(dni);
		jugador.setFechaNacimiento(fechaNacimiento);
		jugador.setEstatura(estatura);
		jugador.setPeso(peso);
		jugador.setPosicion(posicion);
		jugador.setNumeroCamiseta(numeroCamiseta);
		return true;
	}
    
	//----------------------------------------------------EQUIPO----------------------------------------------------------------
	public Equipo existeEquipo(String nombre) {
	    	
	    	Equipo equipo = null;
	    	int i=0;
	    	
	    	while(i<lstEquipos.size() && equipo==null) {
	    		if(lstEquipos.get(i).getNombre().equalsIgnoreCase(nombre)) {
	    			equipo=lstEquipos.get(i);
	    		}
	    		i++;
	    	}
	    	return equipo;
	    }
	
	public Equipo traerEquipo(int id) {
    	
    	Equipo equipo = null;
    	int i=0;
    	
    	while(i<lstEquipos.size() && equipo==null) {
    		if(lstEquipos.get(i).getIdEquipo()==id) {
    			equipo=lstEquipos.get(i);
    		}
    		i++;
    	}
    	return equipo;
    }
    
   public boolean agregarEquipo(String nombre, LocalDate fechaFundacion) throws Exception {
	   
	   Equipo equipo = existeEquipo(nombre);
	   if(equipo!=null) throw new Exception("ERROR: El equipo ya existe");
	   
	   int id = 1;
	   if(!lstEquipos.isEmpty()) {
		   id=lstEquipos.get(lstEquipos.size()-1).getIdEquipo()+1;
	   }
	   
	   return lstEquipos.add(new Equipo(id, nombre, fechaFundacion));
	   
   }
    
   
   public boolean eliminarEquipo(int id) throws Exception {
	   
	   Equipo equipoAux=traerEquipo(id);
	   if(equipoAux==null) throw new Exception("ERROR: El Equipo que desea eliminar no existe");
	   
	   int i=0;
		int j=0;
		boolean encontrado=false;
		
		while(i<lstTorneos.size() && encontrado==false) {
			while(j<lstTorneos.get(i).getEquipos().size() && encontrado==false) {
				if(lstTorneos.get(i).getEquipos().get(j).getIdEquipo()==id) {
					encontrado=true;
				}
				j++;
			}
			i++;
		}
	   
		if(encontrado==true) throw new Exception("ERROR: El equipo pertenece a un torneo");
		
		return lstEquipos.remove(equipoAux);
		
   }
   
   
   public boolean modificarEquipo(int id, String nombre, LocalDate fechaFundacion) throws Exception {
	   
	   Equipo equipoAux=traerEquipo(id);
	   if(equipoAux==null) throw new Exception("ERROR: El equipo que desea modificar no existe");
	   
	   equipoAux.setNombre(nombre);
	   equipoAux.setFechaFundacion(fechaFundacion);
	   
	   return true;
   }
   
   
	//----------------------------------------------------TORNEO-----------------------------------------------------------------

   public Torneo traerTorneo(int id) {
	   
	   Torneo torneo=null;
	   int i=0;
	   
	   while(i<lstTorneos.size() && torneo==null) {
		   if(lstTorneos.get(i).getIdTorneo()==id) {
			   torneo=lstTorneos.get(i);
		   }
		   i++;
	   }
	   
	   return torneo;
	   
   }
   
   private Torneo existeTorneo(String nombre) {
	   
	   Torneo torneo=null;
	   int i=0;
	   
	   while(i<lstTorneos.size() && torneo==null) {
		   if(lstTorneos.get(i).getNombre().equalsIgnoreCase(nombre)) {
			   torneo=lstTorneos.get(i);
		   }
		   i++;
	   }
	   
	   return torneo;
	   
   }
   
   public boolean agregarTorneo(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
	   
	   Torneo torneoAux=existeTorneo(nombre);
	   if(torneoAux!=null) throw new Exception("ERROR: El torneo ya existe");
	   
	   int id=1;
	   if(!lstTorneos.isEmpty()) {
		   id=lstTorneos.get(lstTorneos.size()-1).getIdTorneo()+1;
	   }
	   
	   return lstTorneos.add(new Torneo(id, nombre, temporada, fechaInicio, fechaFin));
	   
   }
   
   public boolean eliminarTorneo(int id) throws Exception {
	   
	   Torneo torneoAux=traerTorneo(id);
	   if(torneoAux==null) throw new Exception("ERROR: El equipo que desea eliminar no existe");
	   
	   return lstTorneos.remove(torneoAux);
	   
   }
   
   public boolean modificarTorneo(int id, String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
	   
	   Torneo torneoAux=traerTorneo(id);
	   if(torneoAux==null) throw new Exception("ERROR: El torneo que desea modificar no existe");
	   
	   torneoAux.setNombre(nombre);
	   torneoAux.setTemporada(temporada);
	   torneoAux.setFechaInicio(fechaInicio);
	   torneoAux.setFechaFin(fechaFin);
	   
	   return true;
   }
   
//----------------------- caso de uso 5: buscar entrenador por tactica -------------------------------------------
   
   public List<Entrenador> traerEntrenadoresPorTactica(String tactica) {
	    List<Entrenador> resultado = new ArrayList<>();
	    for (Entrenador e : lstEntrenadores) {
	        if (e.getEstrategiaFavorita().equalsIgnoreCase(tactica)) {
	            resultado.add(e);
	        }
	    }
	    return resultado;
	}
   
   //---------------------------- caso de uso 6: buscar por entre dos fechas -----------------------------------------
   
   public List<Jugador> traerJugadoresPorRangoDeNacimiento(LocalDate desde, LocalDate hasta) {
	    List<Jugador> resultado = new ArrayList<>();
	    for (Jugador j : lstJugadores) {
	        LocalDate fn = j.getFechaNacimiento();
	        if ((fn.isEqual(desde) || fn.isAfter(desde)) && 
	            (fn.isEqual(hasta) || fn.isBefore(hasta))) {
	            resultado.add(j);
	        }
	    }
	    return resultado;
	}
   
   //--------------------------------- caso de uso 7: equipos fundados antes de una fecha --------------------------------
   
   public List<Equipo> traerEquiposFundadosAntesDe(LocalDate fecha) {
	    List<Equipo> resultado = new ArrayList<>();
	    for (Equipo e : lstEquipos) {
	        if (e.getFechaFundacion().isBefore(fecha)) {
	            resultado.add(e);
	        }
	    }
	    return resultado;
	}

   
	 //------------------CASO DE USO 9------------------
	   public Equipo traerEquipoMayorAlturaPromedio() {
	       if (lstEquipos == null || lstEquipos.isEmpty()) {
	           return null;
	       }
	
	       Equipo equipoMayorPromedio = null;
	       double mayorPromedio = 0;
	
	       for (Equipo e : lstEquipos) {
	           double promedio = e.calcularAlturaPromedio();
	           if (equipoMayorPromedio == null || promedio > mayorPromedio) {
	               equipoMayorPromedio = e;
	               mayorPromedio = promedio;
	           }
	       }
	
	       return equipoMayorPromedio;
	   }
   
	//----------------------------------------------------REGISTRO-----------------------------------------------------------------
	   
	   public Registro traerRegistro(int id) {
		   
		   Registro registro = null;
	    	int i=0;
	    	
	    	while(i<lstRegistros.size() && registro==null) {
	    		if(lstRegistros.get(i).getIdRegistro()==id) {
	    			registro=lstRegistros.get(i);
	    		}
	    		i++;
	    	}
	    	return registro;
	    	
	   }
	   
	   public boolean agregarRegistro(Jugador jugador, int goles, int asistencias, LocalTime minutosJugados, Partido partido) {
		     
		   int id=1;
		   if(!lstRegistros.isEmpty()) {
			   id=lstRegistros.get(lstRegistros.size()-1).getIdRegistro()+1;
		   }
		   
		   return lstRegistros.add(new Registro(id, jugador, goles, asistencias, minutosJugados, partido));
		   
	   }
	   
	   public boolean eliminarRegistro(int id) throws Exception {
		   
		   Registro registro=traerRegistro(id);
		   if(registro==null) throw new Exception("ERROR: El registro que desea eliminar no existe");
		   
		   return lstRegistros.remove(registro);
		   
	   }
	   
	   public boolean modificarRegistro(int id, Jugador jugador, int goles, int asistencias, LocalTime minutosJugados, Partido partido) throws Exception {
		   
		   Registro registro=traerRegistro(id);
		   if(registro==null) throw new Exception("ERROR: El registro que desea modificar no existe");
		   
		   registro.setJugador(jugador);
		   registro.setGoles(goles);
		   registro.setAsistencias(asistencias);
		   registro.setMinutosJugados(minutosJugados);
		   registro.setPartido(partido);
		   return true;
		   
	   }
	   
	   
	   
	   
	   
}
