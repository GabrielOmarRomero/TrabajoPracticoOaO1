package modelo;

import java.time.LocalDate;

public class Jugador extends Persona{
	
	private double estatura;
    private double peso;
    private String posicion;
    private int numeroCamiseta;
	
    public Jugador(int id, String nombre, String apellido, long dni, LocalDate fechaNacimiento, double estatura, double peso,
    String posicion, int numeroCamiseta) {
		super(id, nombre, apellido, dni, fechaNacimiento);
		// TODO Auto-generated constructor stub
		this.estatura=estatura;
		this.peso=peso;
		this.posicion=posicion;
		this.numeroCamiseta=numeroCamiseta;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}

	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}
    
	@Override
    public String toString() {
    	return 	super.toString() + "Estatura: " + String.format("%.2f", estatura) + "\n" + 
    			"Peso: " + String.format("%.2f", peso) + "\n" + 
    			"Posicion: " + posicion + "\n" + 
    			"Numero de camiseta: " + numeroCamiseta + "\n";	
    }
    

}
