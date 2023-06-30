import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HomeComponent} from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HeadComponent } from './head/head.component';
import { FooterComponent } from './footer/footer.component';
import { RegisterComponent } from './auth/register/register.component'



@NgModule({
  declarations: [
    HomeComponent,
    NavbarComponent,
    HeadComponent,
    FooterComponent,
    RegisterComponent
  ],
  imports: [
    CommonModule
  ]
})
export class PageModule { }
