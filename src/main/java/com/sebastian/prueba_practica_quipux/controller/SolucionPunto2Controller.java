package com.sebastian.prueba_practica_quipux.controller;

import com.sebastian.prueba_practica_quipux.services.SolucionPunto2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hora_minutos")
@CrossOrigin(origins = "*")
public class SolucionPunto2Controller {

    @Autowired
    private SolucionPunto2Service solucionPunto2Service;

    @GetMapping("/punto2/consola")
    public String horaMinutosPalabras() {
        return solucionPunto2Service.resultadoHoraMinutosPalabras();
    }

}
