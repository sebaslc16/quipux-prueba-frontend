package com.sebastian.prueba_practica_quipux.services;

import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

@Service
public class SolucionPunto1Service {

    /**
     * Solución recibiendo el numero mediante un JSON
     * Imprimir “Quipux” o “No Quipux” basado en las restricciones
     *
     * @param numero a evaluar para retornar mensaje
     * @return el mensaje string "Quipux" o "No quipux"
     */
    public String numeroParImparJSON(Integer numero) {

        //Mensaje que se retornara segun las restriccion
        String mensaje = "";

        //Restrincción inicial para numero
        if (!(numero >= 1 && numero <= 100)) {
            mensaje = "Número no permitido";
        }

        //Es par
        if (numero % 2 == 0) {
            //Par en rango inclusivo de 2 a 5
            if (numero >= 2 && numero <= 5) mensaje = "No Quipux";

            //Par en rango inclusivo de 6 a 20
            if (numero >= 6 && numero <= 20) mensaje = "Quipux";

                //Mayor a 20
            else mensaje = "No Quipux";
        }
        //Impar
        else {
            mensaje = "Quipux";
        }

        return mensaje;
    }

    /**
     *
     * Solucion por medio de consola
     */
    public String numeroParImparConsola() {

        Scanner sc = new Scanner(System.in);

        //Mensaje que se retornara segun las restriccion
        String mensaje = "";

        try {

            System.out.println("Por favor ingrese el número");//Se pide un dato al usuario
            int numero = sc.nextInt();

            //Restrincción inicial para numero
            if (!(numero >= 1 && numero <= 100)) {
                mensaje = "Número no permitido";
            }

            //Es par
            if (numero % 2 == 0) {
                //Par en rango inclusivo de 2 a 5
                if (numero >= 2 && numero <= 5) mensaje = "No Quipux";

                //Par en rango inclusivo de 6 a 20
                if (numero >= 6 && numero <= 20) mensaje = "Quipux";

                    //Mayor a 20
                else mensaje = "No Quipux";
            }
            //Impar
            else {
                mensaje = "Quipux";
            }

            sc.nextLine();

        } catch (InputMismatchException e) {
            sc.nextLine();
            mensaje = "Valor invalido, intenta de nuevo e ingresa un número valido";
            System.out.println(mensaje);
            return mensaje;
        }

        System.out.println(mensaje);
        return mensaje;
    }
}
