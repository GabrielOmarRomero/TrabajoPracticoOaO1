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
    
    public boolean agregarJugadorEquipo(Jugador jugador) throws Exception {
    	Jugador jugadorAux=null;
    	int i=0;
    	
    	while(i<lstJugadoresEquipo.size() && jugadorAux==null) {
    		if(lstJugadoresEquipo.get(i).getDni()==jugador.getDni()) {
    			jugadorAux=lstJugadoresEquipo.get(i);
    		}
    		i++;
    	}
    	
    	if(jugadorAux!=null) throw new Exception("ERROR: El jugador ya pertenece al equipo");
    	
 	   	return lstJugadoresEquipo.add(jugador);
    }
    
    public boolean eliminarJugadorEquipo(Jugador jugador) throws Exception {
    	
    	int i=0;
    	boolean encontrado=false;
    	
    	while(i<lstJugadoresEquipo.size() && encontrado==false) {
    		if(lstJugadoresEquipo.get(i).getDni()==jugador.getDni()) {
    			encontrado=true;
    		}
    		i++;
    	}
    	
    	if(encontrado==false) throw new Exception("ERROR: El jugador no se encuentra dentro de la lista del equipo");
    	
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
