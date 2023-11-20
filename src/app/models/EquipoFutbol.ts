import { Jugador } from "./Jugador";

export interface EquipoFutbol {
  nombreEquipo: string;
  estadioEquipo: string;
  cantidadTitulos: number;
  titulares: Jugador[];
  suplentes: Jugador[];
}
