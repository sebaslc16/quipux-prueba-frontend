import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { EquipoFutbol } from '../models/EquipoFutbol';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EquipoFutbolService {

  urlServiceEquipoFutbol: string = "http://localhost:8080/equipo_futbol/";

  constructor(private http: HttpClient) { }

  //Servicio que consume endpoint de registro de equipo y generar reporte
  public getReportEquipoFutbol(body : EquipoFutbol): Observable<EquipoFutbol> {
    return this.http.post<EquipoFutbol>(this.urlServiceEquipoFutbol+"punto3/json",body);
  }

}
