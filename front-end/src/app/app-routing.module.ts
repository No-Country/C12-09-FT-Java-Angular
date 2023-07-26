import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';



const routes: Routes = [
  // { path: '', component: HomeComponent }, // Asegúrate de que la ruta para HomeComponent esté configurada correctamente
  // { path: 'login', component: LoginComponent},
  // { path: 'perfil', component: ProfileComponent},
  // { path: 'register', component: RegisterComponent},
  // { path: 'suplementos', component: ProductsCategoryComponent}
  {path: 'cart', component: CartComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
