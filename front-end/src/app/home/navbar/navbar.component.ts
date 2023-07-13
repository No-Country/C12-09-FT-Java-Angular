import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/services/token.service';
import * as $ from 'jquery';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  isLogged = false;

  constructor(private router:Router, private tokenService: TokenService) { }

   ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    $(document).ready(() => {
      $("#sidebarCollapse").on("click", () => {
        $("#sidebar").addClass("active");
      });

      $("#sidebarCollapseX").on("click", () => {
        $("#sidebar").removeClass("active");
      });

      $("#sidebarCollapse").on("click", () => {
        if ($("#sidebar").hasClass("active")) {
          $(".overlay").addClass("visible");
          console.log("it's working!");
        }
      });

      $("#sidebarCollapseX").on("click", () => {
        $(".overlay").removeClass("visible");
      });
    });
  }

  onLogOut():void{
    this.tokenService.logOut();
    window.location.reload();
  }

  login(){
    this.router.navigate(['/login'])
  }

}

