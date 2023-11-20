package com.sebastian.prueba_practica_quipux.controller;

import com.sebastian.prueba_practica_quipux.services.SolucionPunto1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/par_impar")
@CrossOrigin(origins = "*")
public class SolucionPunto1Controller {

    @Autowired
    private SolucionPunto1Service solucionPrueba;

    //Endpoint para solución por medio de consola
    @GetMapping("/punto1/consola")
    public String numeroParImparConsola() {
        return solucionPrueba.numeroParImparConsola();
    }

    //Endpoint para solucion por medio de JSON, el nombre del valor en el json es "n"
    /**
     *
     * Ejemplo : {"n": 6}
     */
    @GetMapping("/punto1/json")
    public String numeroParImparJSON(@RequestBody Map<String, Integer> numero) {

        Integer n = numero.get("n");
        if(n == null) return "Ingrese un valor";

        else {
            return solucionPrueba.numeroParImparJSON(n);
        }

    }

}
