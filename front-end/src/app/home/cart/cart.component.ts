import { Component, OnDestroy, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/services/user/auth.service';
import { ToastrService } from 'ngx-toastr';
import { TotalItemService } from 'src/app/services/total-item.service';
import { CartResponse } from 'src/app/model/cart-response';
import { TokenService } from 'src/app/services/token.service';
import { TokenStoreService } from 'src/app/services/token-store.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit, OnDestroy{
  public product : any = [];
  public subTotal !: any;
  public grandTotal !: any;
  cartData!: CartResponse | null;
  loading: boolean = true;
  error: boolean = false;
  public totalItem : number = 0;

  constructor(private cartService : CartService, private authService:AuthService,
    private tostr:ToastrService, private totalItemService:TotalItemService,
    private tokenService:TokenStoreService) { }

   // Reemplaza esto con el ID del carrito que deseas mostrar

  private subscription: Subscription = new Subscription();




  ngOnInit(): void {
    /*
    this.cartService.getProduct()
    .subscribe(res=>{
      this.product = res;
      this.subTotal = this.cartService.getTotalPrice();
      this.grandTotal += this.subTotal + 132,0 ;
    })*/
    this.getCartDetails();

  }
  estaLogueado(): boolean{
   return this.tokenService.isLoggued();
  }

  deleteProduct(id:number){
    alert("click");
  }
  getCartDetails(): void {
    this.subscription = this.cartService.cart$.subscribe(
      (cartData: CartResponse | null) => {
        this.cartData = cartData;
        this.loading = false;
        this.error = !cartData; // Si cartData es null, hay un error
        this.totalItem = cartData?.quantity ?? 0;
        // Actualiza el valor del totalItem en el servicio
        this.totalItemService.setTotalItem(this.totalItem);
      }
    );
    const cartId = this.authService.getCartId();
    if(cartId != null){
      this.cartService.getCartById(cartId);
    }else{
      this.tostr.error("Error al devolver productos");
    }
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  removeItem(item: any){
    this.cartService.removeCartItem(item);
  }
  emptycart(){
    this.cartService.removeAllCart();
  }

}

