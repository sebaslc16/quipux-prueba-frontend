package com.sebastian.prueba_practica_quipux.services;

import com.sebastian.prueba_practica_quipux.entity.EquipoFutbol;
import com.sebastian.prueba_practica_quipux.entity.Jugador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class SolucionPunto3Service {

    public String reporteEquipoFutbol() {

        EquipoFutbol equipo = new EquipoFutbol();
        String resultadoReporte = "";

        Scanner sc = new Scanner(System.in);

        //Booleans para validar hasta que se ingresen valores validos
        boolean cantidadTitulosInvalidos = true;
        boolean jugadoresTitularesInvalidos = true;
        boolean jugadoresSuplentesInvalidos = true;

        boolean noFinalizarReporte = true; // boolean para controlar cuando se finaliza el reporte

        //Nombre de equipo
        System.out.println("Por favor ingrese el nombre del equipo");//Se pide el nombre del equipo
        String nombreEquipo = sc.nextLine();
        equipo.setNombreEquipo(nombreEquipo);

        //Estadio de equipo
        System.out.println("Por favor ingrese el estadio del equipo");//Se pide el estadio del equipo
        equipo.setEstadioEquipo(sc.nextLine());

        //Cantidad de titulos
        do {
            try {
                System.out.println("Por favor ingrese la cantidad de titulos");//Se pide el estadio del equipo
                int cantidadTitulos = sc.nextInt();
                equipo.setCantidadTitulos(cantidadTitulos);
                sc.nextLine();
                cantidadTitulosInvalidos= false;
            }
            catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Cantidad de titulos invalidos, por favor intenta nuevamente");

            }
        }
        while(cantidadTitulosInvalidos);

        //Jugadores titulares
        do {
            try {
                System.out.println("Ingrese la cantidad de jugares titulares que quiere ingresar");
                int cantidadJugadoresTitulares = sc.nextInt();
                sc.nextLine();
                equipo.setTitulares(registrarJugadores(cantidadJugadoresTitulares, sc));
                jugadoresTitularesInvalidos = false;
            }
            catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Cantidad de jugadores titulares invalidos, por favor intenta nuevamente");

            }
        }
        while(jugadoresTitularesInvalidos);

        //Jugadores suplentes
        do {
            try {
                System.out.println("Ingrese la cantidad de jugares suplentes que quiere ingresar");
                int cantidadJugadoresSuplentes = sc.nextInt();
                sc.nextLine();
                equipo.setSuplentes(registrarJugadores(cantidadJugadoresSuplentes, sc));
                jugadoresSuplentesInvalidos = false;
            }
            catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Cantidad de jugadores suplentes invalidos, por favor intenta nuevamente");

            }
        }
        while(jugadoresSuplentesInvalidos);

        // SELECCIONAR REPORTE
        do {
                System.out.println("Seleccione tipo de reporte, presione la tecla correspondiente y presione enter");
                System.out.println("a) Reporte básico    b) Reporte detallado   c) Salir");
            switch (sc.nextLine()) {
                case "a" -> { //Opción 'a' reporte básico
                    System.out.println("**************Reporte Básico**************");
                    System.out.println("Nombre de equipo      : " + equipo.getNombreEquipo());
                    System.out.println("Títulos ganados       : " + equipo.getCantidadTitulos());
                    System.out.println("Cantidad de jugadores : " + (equipo.getTitulares().size() + equipo.getSuplentes().size()));
                }
                case "b" -> { //Opción 'b' reporte básico
                    System.out.println("**************Reporte Detallado**************");
                    System.out.println("Nombre de equipo      : " + equipo.getNombreEquipo()+"\n");
                    System.out.println("Jugadores Titulares   : \n" + detalleJugadores(equipo.getTitulares()));
                    System.out.println("Jugadores Suplentes   : \n" + detalleJugadores(equipo.getSuplentes()));
                }
                case "c" -> noFinalizarReporte = false; //Salir y terminar
                default -> System.out.println("Ingrese una opción valida"); //opcion no disponible
            }
        }
        while(noFinalizarReporte);

        return "";
    }

    //Metoodo para registrar la informacion de los jugadores por medio de la consola
    //Recibe la cantidad de jugadores a registrar
    public List<Jugador> registrarJugadores(Integer cantidadJugadores, Scanner sc){

        List<Jugador> listaJugadores = new ArrayList<>();

        for (int i = 1; i <= cantidadJugadores; i++) {
            Jugador jugador = new Jugador();
            System.out.println("Ingrese el nombre del jugador "+ i );
            String nombreJugador = sc.nextLine();
            jugador.setNombre(nombreJugador);
            System.out.println("Ingrese la posicion del jugador "+ i );
            String posicionJugador = sc.nextLine();
            jugador.setPosicion(posicionJugador);
            listaJugadores.add(jugador);
        }

        return listaJugadores;

    }

    //Metodo que elabora el detalle de cada jugador
    public String detalleJugadores(List<Jugador> jugadores) {

        StringBuilder detalleJugadores = new StringBuilder();

        for (Jugador jugadorEquipo : jugadores) {
            detalleJugadores.append(jugadorEquipo.getNombre()).append(" - ").append(jugadorEquipo.getPosicion()).append("\n");
        }

        return detalleJugadores.toString();

    }

}
