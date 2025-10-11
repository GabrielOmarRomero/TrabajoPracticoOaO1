package modelo;

import java.time.LocalDate;

public class Entrenador extends Persona{
	
	private String estrategiaFavorita;
	
    public Entrenador(int id, String nombre, String apellido, long dni, LocalDate fechaNacimiento, String estrategiaFavorita) {
		super(id, nombre, apellido, dni, fechaNacimiento);
		// TODO Auto-generated constructor stub
		this.estrategiaFavorita=estrategiaFavorita;
	}

	public String getEstrategiaFavorita() {
		return estrategiaFavorita;
	}

	public void setEstrategiaFavorita(String estrategiaFavorita) {
		this.estrategiaFavorita = estrategiaFavorita;
	}
    
    @Override
    public String toString() {
    	return 	super.toString() + "Estrategia favorita: " + estrategiaFavorita + "\n";	
    }

}
