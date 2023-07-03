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
import { FormsModule } from '@angular/forms';
<<<<<<< Updated upstream
=======
import { RegisterComponent } from './home/register/register.component';
import { ProfileComnent } from './home/profile/profile.component';
import { CategoriesComponent } from './home/categories/categories.component';
>>>>>>> Stashed changes

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
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
<<<<<<< Updated upstream
    LoginComponent
=======
    LoginComponent,
    RegisterComponent,
    ProfileComnent,
    CategoriesComponent
>>>>>>> Stashed changes
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes, { useHash: false }),
    FormsModule
  ],
  providers: [
    RouterModule,
    AppComponent,
    HomeComponent,
    NavbarComponent,
    BodyComponent,
    FooterComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
