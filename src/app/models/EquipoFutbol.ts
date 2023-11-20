import { Jugador } from "./Jugador";

/** Entidad equipo de futbol */
export interface EquipoFutbol {
  nombreEquipo: string;
  estadioEquipo: string;
  cantidadTitulos: number;
  titulares: Jugador[];
  suplentes: Jugador[];
}
