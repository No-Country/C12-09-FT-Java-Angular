import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-products-category',
  templateUrl: './products-category.component.html',
  styleUrls: ['./products-category.component.css']
})
export class ProductsCategoryComponent implements OnInit{


  products: Product[] = [];

  constructor(private productService:ProductService,
    private toastr: ToastrService,
    private router: Router){}

  ngOnInit(): void {

  }

  getProducts(categoryName: string){
    this.productService.getProductsForCategory(categoryName).subscribe(
      data => {
        console.log(data);
        this.products = data;
      },
      err =>{
        console.error(err);
      }
    )
  }

}
