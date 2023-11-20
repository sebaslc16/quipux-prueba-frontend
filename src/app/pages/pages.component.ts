import { Component } from '@angular/core';
import { EquipoFutbol } from '../models/EquipoFutbol';
import { Jugador } from '../models/Jugador';
import Swal from 'sweetalert2';
import { EquipoFutbolService } from '../services/equipo-futbol.service';

@Component({
  selector: 'app-pages',
  templateUrl: './pages.component.html',
  styleUrls: ['./pages.component.css']
})
export class PagesComponent {

  //Se almacenara la informacion del equipo
  equipoResultado: EquipoFutbol | undefined;

  //Informacion del equipo
  nombreEquipo: string = "";
  estadioEquipo: string = "";
  titulos: number = 0;
  cantidadTitulares: number = 0;
  cantidadSuplentes: number = 0;
  listaJugadoresTitulares: Jugador[] = [];
  listaJugadoresSuplentes: Jugador[] = [];

  totalJugadores : number = 0;

  jugadorFormulario: any = {};

  constructor(private equipoService: EquipoFutbolService) { }

  ngOnInit(): void {
    this.cantidadTitulares = 0;
    this.cantidadSuplentes = 0;
  }

  // Validaciones para el formulario
  validarFormulario() {

    if (this.nombreEquipo == undefined || this.nombreEquipo == "") {
      Swal.fire({
        position: "top-end",
        icon: "error",
        title: "Ingrese nombre de equipo",
        showConfirmButton: false,
        timer: 1500
      });
      return;
    }

    if (this.estadioEquipo == undefined || this.estadioEquipo == "") {
      Swal.fire({
        position: "top-end",
        icon: "error",
        title: "Ingrese estadio de equipo",
        showConfirmButton: false,
        timer: 1500
      });
      return;
    }

    if (this.listaJugadoresTitulares.length <= 0) {
      Swal.fire({
        position: "top-end",
        icon: "error",
        title: "Registre jugadores titulares",
        showConfirmButton: false,
        timer: 1500
      });
      return;
    }

    if (this.listaJugadoresSuplentes.length <= 0) {
      Swal.fire({
        position: "top-end",
        icon: "error",
        title: "Registre jugadores suplentes",
        showConfirmButton: false,
        timer: 1500
      });
      return;
    }
  }

  //Agregar jugador suplente o titular
  agregarJugador(tipo: string) {

    if (this.jugadorFormulario['nombre'] == undefined || this.jugadorFormulario['nombre'] == '') {
      Swal.fire({
        position: "top-end",
        icon: "error",
        title: "Ingrese nombre de jugador",
        showConfirmButton: false,
        timer: 1500
      });
      return;
    }
    if (this.jugadorFormulario['posicion'] == undefined || this.jugadorFormulario['posicion'] == '') {
      Swal.fire({
        position: "top-end",
        icon: "error",
        title: "Ingrese posición de jugador",
        showConfirmButton: false,
        timer: 1500
      });
      return;
    }

    let jugadorNuevo: Jugador = {
      nombre: this.jugadorFormulario['nombre'],
      posicion: this.jugadorFormulario['posicion']
    }

    if (tipo == 'titular') {
      this.listaJugadoresTitulares.push(jugadorNuevo);
      this.cantidadTitulares++;
    }
    else {
      this.listaJugadoresSuplentes.push(jugadorNuevo);
      this.cantidadSuplentes++;
    }

    this.jugadorFormulario['nombre'] = "";
    this.jugadorFormulario['posicion'] = "";

  }

  //Limpiar Campos
  public limpiar() {
    this.nombreEquipo = "";
    this.estadioEquipo = "";
    this.titulos = 0;
    this.cantidadSuplentes = 0;
    this.cantidadTitulares = 0;
  }

  //Registrar información de equipo y generar reporte
  public generarReporte() {

    this.validarFormulario();

    let equipo: EquipoFutbol = {
      nombreEquipo: this.nombreEquipo,
      cantidadTitulos: this.titulos,
      estadioEquipo: this.estadioEquipo,
      suplentes: this.listaJugadoresSuplentes,
      titulares: this.listaJugadoresTitulares
    }

    this.equipoService.getReportEquipoFutbol(equipo).subscribe(resp => {
      console.log(resp);
      this.totalJugadores = resp.titulares.length + resp.suplentes.length;
      this.equipoResultado = resp;
    })

  }



}
