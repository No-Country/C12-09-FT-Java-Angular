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

    this.route.params.subscribe(params => {
    this.categoryName = params['category'];
    this.getProducts(this.categoryName);
  });
  }
  selectCategory(category: string) {
    this.categoryName = category;
    this.getProducts(category);
  }

  getProducts(categoryName: string){
    this.productService.getProductsForCategory(categoryName).subscribe(
      (data) => {
          this.products = data;

        },
        err => {
          console.log(err);
          this.toastr.error(err.error.message, 'Sin productos', { timeOut: 3000, positionClass: 'toast-top-right'});
        }

    );
  }

}
