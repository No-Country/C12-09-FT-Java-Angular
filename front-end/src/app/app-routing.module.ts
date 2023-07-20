import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component'; // Asegúrate de importar HomeComponent
import { RegisterComponent } from './home/register/register.component';
import { LoginComponent } from './home/login/login.component';
import { ProfileComponent } from './home/profile/profile.component';
import { NosotrosComponent } from './home/nosotros/nosotros.component';
import { ProductsCategoryComponent } from './home/product/products-category/products-category.component';
import { CartComponent } from './home/cart/cart.component';

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
