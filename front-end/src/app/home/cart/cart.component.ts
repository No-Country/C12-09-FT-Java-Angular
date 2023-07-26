import { Component } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { Product } from 'src/app/model/product';
import { Cart } from 'src/app/model/cart';
import { Subscription } from 'rxjs';
import { CartResponse } from 'src/app/model/cart-response';
import { AuthService } from 'src/app/services/user/auth.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {
  public product : any = [];
  public subTotal !: any;
  public grandTotal !: any;
  cartData: CartResponse | null = null;
  loading: boolean = true;
  error: boolean = false;
  constructor(private cartService : CartService, private authService:AuthService,
    private tostr:ToastrService) { }

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

  getCartDetails(): void {
    this.subscription = this.cartService.cart$.subscribe(
      (cartData: Cart | null) => {
        this.cartData = cartData;
        this.loading = false;
        this.error = !cartData; // Si cartData es null, hay un error
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

