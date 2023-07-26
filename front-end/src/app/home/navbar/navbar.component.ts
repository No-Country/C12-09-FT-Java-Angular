import { Component} from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/services/token.service';
import * as $ from 'jquery';
import { SearchService } from 'src/app/search.service';
import { CartService } from 'src/app/services/cart.service';
import { TokenStoreService } from 'src/app/services/token-store.service';
import { AuthService } from 'src/app/services/user/auth.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  isLogged = false;
  public totalItem : number = 0;
  searchValue: string = '';
  nameUser: string | null = "";

  constructor(private router:Router, private tokenService: TokenService,private cartService: CartService,
    private searchService: SearchService, private tokenStore:TokenStoreService,
    private authService:AuthService) { }


   ngOnInit(): void {

    this.cartService.getProducts()
    .subscribe(res=>{
      this.totalItem = res.length;
    })

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

  onSearchSubmit() {
    // Redirige a la vista FilterComponent con el término de búsqueda como parámetro de ruta
    this.router.navigate(['/filter'], { queryParams: { search: this.searchValue } });
  }

  estaVaciosearchValue():boolean{
    return this.searchValue.length > 0;
  }

  estaLogueado():boolean{
    if(this.tokenStore.isLoggued()){
      this.nameUser = this.authService.getNameUser();
    }
    return this.tokenStore.isLoggued();
  }

  cerrarSesion():void{
    this.tokenStore.logOut();
    this.authService.removeCartId();
    this.authService.removeNameUser();
    this.router.navigateByUrl('/login');
  }

}



