import { Component } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { Product } from 'src/app/model/product';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {
  public product : any = [];
  public subTotal !: any;
  public grandTotal !: any;
  constructor(private cartService : CartService) { }

  ngOnInit(): void {
    this.cartService.getProduct()
    .subscribe(res=>{
      this.product = res;
      this.subTotal = this.cartService.getTotalPrice();
      this.grandTotal += this.subTotal + 132,0 ;
    })
  }
  removeItem(item: any){
    this.cartService.removeCartItem(item);
  }
  emptycart(){
    this.cartService.removeAllCart();
  }

}

