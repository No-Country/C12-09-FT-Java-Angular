import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/services/product.service';


@Component({
  selector: 'app-products-category',
  templateUrl: './products-category.component.html',
  styleUrls: ['./products-category.component.css'],

})
export class ProductsCategoryComponent implements OnInit{

  categoryName: string = '';
  products: Product[] = [];


  constructor(private productService:ProductService,
    private toastr: ToastrService,
    private route: ActivatedRoute){}

  ngOnInit(): void {
    this.routeCategory();
    this.route.params.subscribe(params => {
    this.categoryName = params['category'];
  });
  }
  selectCategory(category: string) {
    this.categoryName = category;
    this.getProducts(category);
  }
  routeCategory(){
    this.route.params.subscribe(params => {
      const categoryName = params['category'];
      this.getProducts(categoryName);
    });
  }
  getProducts(categoryName: string){
    this.productService.getProductsForCategory(categoryName).subscribe(
      data => {
        console.log(data);
        this.products = data;
        console.log(this.products)
      },
      err =>{
        console.error(err);
      }
    )
  }

}
