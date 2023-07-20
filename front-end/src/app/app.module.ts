import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './home/navbar/navbar.component';
import { BodyComponent } from './home/body/body.component';
import { FooterComponent } from './home/footer/footer.component';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { CarouselComponent } from './shared/carousel/carousel.component';
import { CarouselProductComponent } from './shared/carousel-product/carousel-product.component';
import { CarouselSponsorComponent } from './shared/carousel-sponsor/carousel-sponsor.component';
import { LoginComponent } from './home/login/login.component';
import { FormGroup, FormsModule, Validators } from '@angular/forms';
import { RegisterComponent } from './home/register/register.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { CategoriesComponent } from './home/categories/categories.component';
import { ProfileComponent } from './home/profile/profile.component';
import{ObjectToArrayPipe} from './shared/carousel-sponsor/objectToarray.pipe';
import { PromocionesComponent } from './shared/promociones/promociones.component'
import { DetailComponent } from './home/product/detail/detail.component';
import { CartComponent } from './home/cart/cart.component';
import { ProductsCategoryComponent } from './home/product/products-category/products-category.component';
import { CommonModule } from '@angular/common';
import { NosotrosComponent } from './home/nosotros/nosotros.component';
import { ProductDetailComponent } from './home/product-detail/product-detail.component';




const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'nosotros', component: NosotrosComponent},
  {path: 'detail/:id', component: DetailComponent},
  {path: 'listCategory/:category', component: ProductsCategoryComponent},
  {path: "cart", component: CartComponent}


];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    BodyComponent,
    FooterComponent,
    CarouselComponent,
    CarouselProductComponent,
    CarouselSponsorComponent,
    LoginComponent,
    RegisterComponent,
    CategoriesComponent,ProfileComponent ,ObjectToArrayPipe, PromocionesComponent,
    DetailComponent,
    CartComponent,
    ProductsCategoryComponent,
    ProductDetailComponent,
    NosotrosComponent,
    ProductsCategoryComponent,
  ],

  imports: [
    BrowserModule,
    RouterModule.forRoot(routes, { useHash: false }),
    FormsModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(), // ToastrModule added
    AppRoutingModule,
    HttpClientModule,
    CommonModule


  ],
  providers: [
    RouterModule,
    AppComponent,
    HomeComponent,
    NavbarComponent,
    BodyComponent,
    FooterComponent,
    RegisterComponent,
    LoginComponent,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
