import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Product } from 'src/app/model/product';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-suplementos',
  templateUrl: './suplementos.component.html',
  styleUrls: ['./suplementos.component.css']
})
export class SuplementosComponent implements OnInit{

  products: Product[] = [];

  constructor(private productService:ProductService,
    private toastr: ToastrService,
    private route: ActivatedRoute,
    private cartService:CartService){}

  ngOnInit(): void {
    this.productService.getProductsForCategory('Suplementos').subscribe(
      response => {
        this.products = response;
      },
      err => {
        this.toastr.info(err.error.message, 'Sin productos en la categoria Suplementos.')
      }
    )
  }

  addtocart(item:any){
    this.cartService.addToCart(item);
  }
}
