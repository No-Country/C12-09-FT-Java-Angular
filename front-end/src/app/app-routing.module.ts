import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './home/register/register.component';
import { LoginComponent } from './home/login/login.component';
import { NosotrosComponent } from './home/nosotros/nosotros.component';
import { loginGuard } from './guards/login.guard';
import { SuccesViewComponent } from './home/pago/succes-view/succes-view.component';
import { FailureViewComponent } from './home/pago/failure-view/failure-view.component';
import { PendingViewComponent } from './home/pago/pending-view/pending-view.component';
import { PaymentResponseComponent } from './home/pago/payment-response/payment-response.component';
import { FilterComponent } from './home/product/filter/filter.component';
import { DetailComponent } from './home/detail/detail.component';
import { CartComponent } from './home/cart/cart.component';
import { SuplementosComponent } from './home/product/suplementos/suplementos.component';
import { EquipamientoComponent } from './home/product/equipamiento/equipamiento.component';
import { IndumentariaComponent } from './home/product/indumentaria/indumentaria.component';
import { ErrorComponentComponent } from './home/error-component/error-component.component';



const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent},
  { path: 'login', component: LoginComponent, canActivate: [loginGuard]},
  { path: 'nosotros', component: NosotrosComponent},
  { path: 'payment/success', component: SuccesViewComponent },
  { path: 'payment/failure', component: FailureViewComponent },
  { path: 'payment/pending', component: PendingViewComponent },
  { path: 'payment-response', component: PaymentResponseComponent},
  { path: 'filter', component: FilterComponent},
  { path: 'detail/:id', component: DetailComponent},
 // { path: 'listCategory/:category', component: ProductsCategoryComponent},
  { path: "cart", component: CartComponent},
  { path: 'listCategory/Suplementos', component: SuplementosComponent },
  { path: 'listCategory/Equipamiento', component: EquipamientoComponent },
  { path: 'listCategory/Indumentaria', component: IndumentariaComponent },
  { path: 'error', component: ErrorComponentComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
