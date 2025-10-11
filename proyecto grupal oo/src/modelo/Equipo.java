package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
	
	private int idEquipo;
    private String nombre;
    private String codigo;
    private Entrenador entrenador;
    private LocalDate fechaFundacion;
    private List<Jugador> lstJugadoresEquipo;
    
	public Equipo(int idEquipo, String nombre, LocalDate fechaFundacion) {
		super();
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.fechaFundacion = fechaFundacion;
		this.codigo = generarCodigo(nombre);
		this.entrenador = null;
		this.lstJugadoresEquipo = new ArrayList<>();
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		this.codigo= generarCodigo(nombre);
	}
	
	public LocalDate getFechaFundacion() {
		return fechaFundacion;
	}

	public void setFechaFundacion(LocalDate fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public List<Jugador> getJugadores() {
		return lstJugadoresEquipo;
	}

    private String generarCodigo(String nombre) {
    	
    	char primer = nombre.charAt(0);
    	char segundo = nombre.charAt(nombre.length()/2);
    	if(segundo==' ') {
    	segundo = nombre.charAt((nombre.length()/2)+1);	
    	}
    	char tercer = nombre.charAt(nombre.length()-1);
    	String codigo = "" + primer + segundo + tercer;
    	
    	
    	return codigo.toUpperCase();
    }
    
    //------------------MANEJAR JUGADOR------------------
    
    public Jugador traerJugador(long dni) {
    	
    	Jugador jugador=null;
    	int i=0;
    	
    	while(i<lstJugadoresEquipo.size() && jugador==null) {
    		if(lstJugadoresEquipo.get(i).getDni()==dni) {
    			jugador=lstJugadoresEquipo.get(i);
    		}
    		i++;
    	}
    	return jugador;
    }
    
    public boolean agregarJugadorEquipo(Jugador jugador) throws Exception {
    	
    	Jugador jugadorAux=traerJugador(jugador.getDni());
    	if(jugadorAux!=null) throw new Exception("ERROR: El jugador ya pertenece al equipo");
    	
 	   	return lstJugadoresEquipo.add(jugadorAux);
    }
    
    public boolean eliminarJugadorEquipo(Jugador jugador) throws Exception {
    	
    	Jugador jugadorAux=traerJugador(jugador.getDni());
    	if(jugadorAux==null) throw new Exception("ERROR: El jugador no pertenece al equipo");
    	
    	return lstJugadoresEquipo.remove(jugador);
    }
    
  //------------------MANEJAR ENTRENADOR------------------
    
    public boolean agregarEntrenadorEquipo(Entrenador entrenador) throws Exception {
    	
    	if(this.entrenador!=null) throw new Exception("ERROR: El equipo ya tiene un entrenador");
    	
    	setEntrenador(entrenador);
    	
    	return true;
    }
    
    public boolean eliminarEntrenadorEquipo(Entrenador entrenador) throws Exception {
    	
    	if(this.entrenador==null || this.entrenador.getDni()!=entrenador.getDni()) throw new Exception("ERROR: El entrenador no pertenece al equipo");
    	
    	this.entrenador=null;
    	
    	return true;
    	
    }
    
	//------------------CASO DE USO 8------------------
	    
	    public double calcularAlturaPromedio() {
	        if (lstJugadoresEquipo == null || lstJugadoresEquipo.isEmpty()) {
	            return 0;
	        }
	
	        double sumaAlturas = 0;
	        for (Jugador j : lstJugadoresEquipo) {
	            sumaAlturas += j.getEstatura();
	        }
	
	        return sumaAlturas / lstJugadoresEquipo.size();
	    }
    
    
    //--------------OTROS--------------
    @Override
    public String toString() {
    	return	"ID: " + idEquipo + "\n" +
    			"Nombre: " + nombre + "\n" +
    			"Codigo: " + codigo + "\n" +
    			"Fundado: " + fechaFundacion + "\n" +
    			"------Entrenador------"+"\n"+ entrenador + "\n" + 
    			"------Plantel------"+"\n"+ lstJugadoresEquipo + "\n";
    }
    
}
