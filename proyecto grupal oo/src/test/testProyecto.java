package test;

import java.time.LocalDate;
import java.util.List;

import modelo.Entrenador;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Sistema;
import modelo.Torneo;

public class testProyecto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sistema sistema = new Sistema();
		
		//-------------------ENTRENADOR--------------------
		try{
			sistema.agregarEntrenador("Mariano", "Lopez", 11111111, LocalDate.of(1990, 2, 12), "Presion alta");
			//modificar:
			sistema.agregarEntrenador("Lucas", "Rodriguez", 22222222, LocalDate.of(1988, 10, 18), "Linea de 4");
			//eliminar:
			sistema.agregarEntrenador("Thomas", "Castro", 33333333, LocalDate.of(1987, 1, 11), "Linea de 4");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("--------------ENTRENADORES--------------");
		for(Entrenador e : sistema.getLstEntrenadores()) {
			System.out.println(e);
		}
		
		try{
			sistema.modificarEntrenador("Martin", "Pascareli", 22222222, LocalDate.of(1988, 10, 20), "Linea de 5");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try{
			sistema.eliminarEntrenador(33333333);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("--------------ENTRENADORES (POST MODIFICAR Y ELIMINAR)--------------");
		for(Entrenador e : sistema.getLstEntrenadores()) {
			System.out.println(e);
		}
		
		
		//-------------------JUGADOR--------------------
		try{
			sistema.agregarJugador("Jose", "Martinez", 12121212, LocalDate.of(2000, 5, 1), 1.70f, 75f, "Delantero", 3);
			//modificar:
			sistema.agregarJugador("Agustin", "Menendez", 23232323, LocalDate.of(2002, 9, 21), 1.73f, 71f, "Defensor", 8);
			//elimininar:
			sistema.agregarJugador("Hector", "Borges", 34343434, LocalDate.of(2003, 11, 30), 1.73f, 71f, "Defensor", 16);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("--------------JUGADORES--------------");
		for(Jugador j : sistema.getLstJugadores()) {
			System.out.println(j);
		}
		
		try{
			sistema.modificarJugador("Sebastian", "Sosa", 23232323, LocalDate.of(2001, 6, 7), 1.80f, 80f, "Delantero", 9);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try{
			sistema.eliminarJugador(34343434);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("--------------JUGADORES (POST MODIFICAR Y ELIMINAR)--------------");
		for(Jugador j : sistema.getLstJugadores()) {
			System.out.println(j);
		}
		
		//-------------------EQUIPO--------------------
		
		try{
			sistema.agregarEquipo("Boca Juniors", LocalDate.of(1905, 4, 3));
			sistema.agregarEquipo("River Plate", LocalDate.of(1901, 5, 25));
			//modificar:
			sistema.agregarEquipo("Equipo Pato", LocalDate.of(1900, 3, 5));
			//elimininar:
			sistema.agregarEquipo("Equipo Ganzo", LocalDate.of(1909, 10, 8));
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("--------------EQUIPOS--------------");
		for(Equipo eq : sistema.getLstEquipos()) {
			System.out.println(eq);
		}
		
		try{
			sistema.modificarEquipo(2, "Equipo Azul", LocalDate.of(1910, 12, 7));
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try{
			sistema.eliminarEquipo(4);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("--------------EQUIPOS (POST MODIFICAR Y ELIMINAR)--------------");
		for(Equipo eq : sistema.getLstEquipos()) {
			System.out.println(eq);
		}
		
		//-------------------TORNEO--------------------
		
		try{
			sistema.agregarTorneo("Copa de la Liga Profesional", "Temporada regular", LocalDate.of(2025, 4, 2), LocalDate.of(2025, 10, 5));
			//modificar:
			sistema.agregarTorneo("Copa Sudamericana", "Fase de grupos", LocalDate.of(2025, 3, 22), LocalDate.of(2025, 11, 15));
			//eliminar:
			sistema.agregarTorneo("Copa America", "Fase de grupos", LocalDate.of(2025, 8, 23), LocalDate.of(2026, 5, 10));
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("--------------TORNEOS--------------");
		for(Torneo t : sistema.getLstTorneos()) {
			System.out.println(t);
		}
		
		try{
			sistema.modificarTorneo(2, "Premier League", "Fase de grupos", LocalDate.of(2025, 4, 12), LocalDate.of(2025, 12, 5));
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try{
			sistema.eliminarTorneo(3);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("--------------TORNEOS (POST MODIFICAR Y ELIMINAR)--------------");
		for(Torneo t : sistema.getLstTorneos()) {
			System.out.println(t);
		}
		
		
		System.out.println("--------------EQUIPOS CON AGREGACION DE ENTRENADOR Y JUGADOR--------------");
		
		try{
			sistema.traerEquipo(1).agregarEntrenadorEquipo(sistema.traerEntrenador(11111111));
			sistema.traerEquipo(2).agregarEntrenadorEquipo(sistema.traerEntrenador(22222222));
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try{
			sistema.traerEquipo(1).agregarJugadorEquipo(sistema.traerJugador(12121212));
			sistema.traerEquipo(2).agregarJugadorEquipo(sistema.traerJugador(23232323));
		}catch(Exception e) {
			System.out.println(e);
		}
		
		for(Equipo eq : sistema.getLstEquipos()) {
			System.out.println(eq);
		}
		
		//-------------------------------------------- TEST 8--------------------------------------------------------------
		
		System.out.println("\n");
		System.out.println("Altura Promedio del Equipo - ID " + sistema.traerEquipo(1).getIdEquipo() + " - : " + String.format("%.2f", sistema.traerEquipo(1).calcularAlturaPromedio()));
		
		
		//-------------------------------------------- TEST 9--------------------------------------------------------------
		System.out.println("\n");
		System.out.println("--------------EQUIPO CON MAYOR ALTURA PROMEDIO--------------");
		System.out.println(sistema.traerEquipoMayorAlturaPromedio());

		
		//------------------------------------------------------------------------------------------------------------------
		try{
			sistema.traerEquipo(1).eliminarEntrenadorEquipo(sistema.traerEntrenador(11111111));
			sistema.traerEquipo(2).eliminarEntrenadorEquipo(sistema.traerEntrenador(22222222));
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try{
			sistema.traerEquipo(1).eliminarJugadorEquipo(sistema.traerJugador(12121212));
			sistema.traerEquipo(2).eliminarJugadorEquipo(sistema.traerJugador(23232323));
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("--------------EQUIPOS CON ELIMINACION DE ENTRENADOR Y JUGADOR--------------");
		
		for(Equipo eq : sistema.getLstEquipos()) {
			System.out.println(eq);
		}
		
		//-------------------------------------- test 5 ------------------------------------------------------
		
		System.out.println("---------------BUSCAR ENTRENADORES POR TÁCTICA--------------");
		
		List<Entrenador> entrenadoresTactica = sistema.traerEntrenadoresPorTactica("Linea de 5");
		for (Entrenador e : entrenadoresTactica) {
		    System.out.println(e);
		}
		
		//--------------------------------------- test 6 ----------------------------------------------------------
		
		System.out.println("----------------BUSCAR JUGADORES NACIDOS ENTRE DOS FECHAS--------------");
		LocalDate desde = LocalDate.of(1999, 1, 1);
		LocalDate hasta = LocalDate.of(2002, 12, 31);
		List<Jugador> jugadoresEntreFechas = sistema.traerJugadoresPorRangoDeNacimiento(desde, hasta);
		for (Jugador j : jugadoresEntreFechas) {
		    System.out.println(j);
		}
		
		//------------------------------------------- test 7 -----------------------------------------------------------
		
		System.out.println("--------------BUSCAR EQUIPOS FUNDADOS ANTES DE UNA FECHA--------------");
		LocalDate fechaLimite = LocalDate.of(1905, 1, 1);
		List<Equipo> equiposAntiguos = sistema.traerEquiposFundadosAntesDe(fechaLimite);
		for (Equipo eq : equiposAntiguos) {
		    System.out.println(eq);
		}
		
		

		
		
		
	}

}
