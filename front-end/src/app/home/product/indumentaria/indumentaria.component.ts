import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Product } from 'src/app/model/product';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-indumentaria',
  templateUrl: './indumentaria.component.html',
  styleUrls: ['./indumentaria.component.css']
})
export class IndumentariaComponent {
  products: Product[] = [];

  constructor(private productService:ProductService,
    private toastr: ToastrService,
    private route: ActivatedRoute,
    private cartService:CartService){}

  ngOnInit(): void {
    this.productService.getProductsForCategory('Indumentaria').subscribe(
      products => {
      this.products = products;
    },
    err => {
      this.toastr.info(err.error,'Sin productos');
    }
    );
  }



  addtocart(item:any){
    this.cartService.addToCart(item);
  }
}
