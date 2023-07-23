import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Product } from 'src/app/model/product';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-equipamiento',
  templateUrl: './equipamiento.component.html',
  styleUrls: ['./equipamiento.component.css']
})
export class EquipamientoComponent implements OnInit {

  products: Product[] = [];

  constructor(private productService:ProductService,
    private toastr: ToastrService,
    private route: ActivatedRoute,
    private cartService:CartService){}

  ngOnInit(): void {
    this.productService.getProductsForCategory('Equipamiento').subscribe(
      products => {
      this.products = products;
    },
    err => {
      this.toastr.info(err.error.message,'Sin productos en la categoria Equipamiento');
    }
    );
  }



  addtocart(item:any){
    this.cartService.addToCart(item);
  }
}
