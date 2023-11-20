import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PagesComponent } from './pages.component';

/**
 * Rutas para navegar por la aplicacion
 * ruta home: principal
 * ruta register/:id: registro o edicion de empleado
 */
const routes: Routes = [
  {
      path: 'home',
      component: PagesComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule { }
