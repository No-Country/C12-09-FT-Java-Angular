import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component'; // Asegúrate de importar HomeComponent
import { RegisterComponent } from './home/register/register.component';

const routes: Routes = [
  { path: '', component: HomeComponent }, // Asegúrate de que la ruta para HomeComponent esté configurada correctamente

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
