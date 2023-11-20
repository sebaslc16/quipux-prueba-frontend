package com.sebastian.prueba_practica_quipux.controller;

import com.sebastian.prueba_practica_quipux.entity.EquipoFutbol;
import com.sebastian.prueba_practica_quipux.services.SolucionPunto3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/equipo_futbol")
@CrossOrigin(origins = "*")
public class SolucionPunto3Controller {

    @Autowired
    private SolucionPunto3Service solucionPunto3Service;

    /**
     * Endpoint con reporte de equipo de futbol, por consola
     */
    @GetMapping("/punto3/consola")
    public void reporteEquipoFutbol() {
        solucionPunto3Service.reporteEquipoFutbol();
    }

    @PostMapping("/punto3/json")
    public ResponseEntity<EquipoFutbol> registrarEquipoFutbol(@RequestBody EquipoFutbol body) {
        return ResponseEntity.ok(body);
    }

}
