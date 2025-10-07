package modelo;

import java.time.LocalDate;

public class Entrenador {
	
	private int idEntrenador;
    private String nombre;
    private String apellido;
    private long dni;
    private LocalDate fechaNacimiento;
    private String estrategiaFavorita;
    
	public Entrenador(int idEntrenador, String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			String estrategiaFavorita) {
		super();
		this.idEntrenador = idEntrenador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.estrategiaFavorita = estrategiaFavorita;
	}

	public int getIdEntrenador() {
		return idEntrenador;
	}

	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEstrategiaFavorita() {
		return estrategiaFavorita;
	}

	public void setEstrategiaFavorita(String estrategiaFavorita) {
		this.estrategiaFavorita = estrategiaFavorita;
	}
    
    @Override
    public String toString() {
    	return "ID: " + idEntrenador + "\n" + 
    			"Apellido y Nombre: " + apellido + ", " + nombre + "\n" + 
    			"DNI: " + dni + "\n" +
    			"Fecha de nacimiento: " + fechaNacimiento + "\n" +  
    			"Estrategia favorita: " + estrategiaFavorita + "\n";
    	
    }

}
