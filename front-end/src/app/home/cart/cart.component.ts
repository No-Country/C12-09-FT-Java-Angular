import { Component } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { Product } from 'src/app/model/product';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {
  public products : any = [];
  public plusShipment !: number;
  public grandTotal !: number;
  constructor(private cartService : CartService) { }

  ngOnInit(): void {
    this.cartService.getProducts()
    .subscribe(res=>{
      this.products = res;
      this.grandTotal = this.cartService.getTotalPrice();
      this.plusShipment += this.grandTotal + 132,0 ;
    })
  }
  removeItem(product: any){
    this.cartService.removeCartItem(product);
  }
  emptycart(){
    this.cartService.removeAllCart();
  }

}

