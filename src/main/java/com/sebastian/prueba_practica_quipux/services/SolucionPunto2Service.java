package com.sebastian.prueba_practica_quipux.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

@Service
public class SolucionPunto2Service {

    /**
     * Solucion punto 2, imprimir hora y minutos dados en palabras
     *
     * @return string con el resultado de la hora y minutos en palabras
     */
    public String resultadoHoraMinutosPalabras() {

        Scanner sc = new Scanner(System.in);

        Map<Integer, String> horasMap = numerosLetrasHoras();

        //Mensaje que se retornara segun la hora y minutos indicado
        String resultado = "";

        boolean horaInvalida = true;
        boolean minutosInvalidos = true;

        //Ciclo hasta que se ingrese una hora valida
        do {

            try {
                System.out.println("Por favor ingrese la hora");//Se pide la hora al usuario
                int hora = sc.nextInt();

                //Restrincción inicial para hora
                if (!(hora >= 1 && hora <= 12)) {
                    System.out.println("Hora invalida");
                    return "Hora invalida";
                }

                resultado += horasMap.get(hora); //se obtiene la hora en palabras mediante el map
                sc.nextLine();
                horaInvalida = false;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Hora invalida, ingresa nuevamente");
            }
        }
        while (horaInvalida);

        //Ciclo hasta que se ingresen minutos validos
        do {
            try {
                System.out.println("Por favor ingrese los minutos");//Se piden los minutos al usuario
                int minutos = sc.nextInt();

                //Restrincción inicial para minutos
                if (!(minutos >= 0 && minutos < 60)) {
                    System.out.println("Minutos invalidos");
                    return "Minutos invalidos";
                } else {
                    resultado += " y " + obtenerMinutosLetras(minutos); //se usa el metodo para obtener los minutos en palabras
                }
                sc.nextLine();
                minutosInvalidos= false;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Minutos invalidos, ingresa nuevamente");
            }
        }
        while (minutosInvalidos);

        System.out.println(resultado);
        return resultado;
    }

    //Crear relacion de numero y letras del 1 al 12
    public Map<Integer, String> numerosLetrasHoras() {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Una");
        map.put(2, "Dos");
        map.put(3, "Tres");
        map.put(4, "Cuatro");
        map.put(5, "Cinco");
        map.put(6, "Seis");
        map.put(7, "Siete");
        map.put(8, "Ocho");
        map.put(9, "Nueve");
        map.put(10, "Diez");
        map.put(11, "Once");
        map.put(12, "Doce");

        return map;
    }

    //Crea relacion numero y letras para los minutos
    public Map<Integer, String> numerosLetrasMinutos() {
        Map<Integer, String> map2 = new HashMap<>();

        map2.put(0, "en punto");
        map2.put(1, "un");
        map2.put(2, "dos");
        map2.put(3, "tres");
        map2.put(4, "cuatro");
        map2.put(5, "cinco");
        map2.put(6, "seis");
        map2.put(7, "siete");
        map2.put(8, "ocho");
        map2.put(9, "nueve");
        map2.put(10, "diez");
        map2.put(11, "once");
        map2.put(12, "doce");
        map2.put(13, "trece");
        map2.put(14, "catorce");
        map2.put(15, "quince");
        map2.put(16, "diez y seis");
        map2.put(17, "diez y siete");
        map2.put(18, "diez y ocho");
        map2.put(19, "diez y nueve");
        map2.put(20, "veinte");
        map2.put(30, "treinta");
        map2.put(40, "cuarenta");
        map2.put(50, "cincuenta");

        return map2;
    }

    /**
     * Metodo para validar y convertir los minutos indicados en palabras
     *
     * @param minutos
     * @return minutos en palabras
     */
    public String obtenerMinutosLetras(Integer minutos) {
        Map<Integer, String> minutosMap = numerosLetrasMinutos();

        String minutosLetra = minutosMap.get(minutos);

        if (minutosLetra == null) {

            String resultadoMinutos = ""; //resultado de los minutos en palabras

            String minutosString = String.valueOf(minutos); //Se pasan los minutos a string

            Integer segundaPosicionMinutos = Integer.parseInt(String.valueOf(minutosString.charAt(1))); //segundo numero de los minutos
            Integer minutosDecena = minutos - segundaPosicionMinutos;

            resultadoMinutos += minutosMap.get(minutosDecena);
            resultadoMinutos += " y " + minutosMap.get(segundaPosicionMinutos) + " minutos";

            return resultadoMinutos;
        } else {
            if (minutos == 30) return "media";
            if (minutos == 0) return minutosLetra;

            else {
                return minutosLetra + " minutos";
            }
        }

    }
}
