package com.sebastian.prueba_practica_quipux.entity;

import java.util.List;

public class EquipoFutbol {

    private String nombreEquipo;
    private String estadioEquipo;
    private Integer cantidadTitulos;
    private List<Jugador> titulares;
    private List<Jugador> suplentes;

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getEstadioEquipo() {
        return estadioEquipo;
    }

    public void setEstadioEquipo(String estadioEquipo) {
        this.estadioEquipo = estadioEquipo;
    }

    public Integer getCantidadTitulos() {
        return cantidadTitulos;
    }

    public void setCantidadTitulos(Integer cantidadTitulos) {
        this.cantidadTitulos = cantidadTitulos;
    }

    public List<Jugador> getTitulares() {
        return titulares;
    }

    public void setTitulares(List<Jugador> titulares) {
        this.titulares = titulares;
    }

    public List<Jugador> getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(List<Jugador> suplentes) {
        this.suplentes = suplentes;
    }
}
