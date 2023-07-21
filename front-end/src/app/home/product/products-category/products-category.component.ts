import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/services/product.service';
import { CartService } from 'src/app/services/cart.service';


@Component({
  selector: 'app-products-category',
  templateUrl: './products-category.component.html',
  styleUrls: ['./products-category.component.css'],

})
export class ProductsCategoryComponent implements OnInit{

  categoryName: string = '';
  products: Product[] = [];
  public productList: any;


  constructor(private productService:ProductService,
    private toastr: ToastrService,
    private route: ActivatedRoute,
    private cartService:CartService){}

  ngOnInit(): void {

    this.route.params.subscribe(params => {
    this.categoryName = params['category'];
    this.getProducts(this.categoryName);
  });
  // Lee los parámetros de la ruta y realiza la búsqueda al cargar el componente
  this.route.queryParams.subscribe(params => {
    const searchValue = params['search'];
    if (searchValue) {
      this.productService.getProductByName(searchValue).subscribe(products => {
        this.products = products;
      });
    }
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
          this.toastr.info(err.error.message, 'Sin productos', { timeOut: 3000, positionClass: 'toast-top-right'});
        }

    );
  }

  addtocart(item:any){
    this.cartService.addToCart(item);
  }
}
