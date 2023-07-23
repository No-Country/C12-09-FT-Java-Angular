import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Subject } from 'rxjs';
import { Product } from 'src/app/model/product';
import { SearchService } from 'src/app/search.service';
import { ProductService } from 'src/app/services/product.service';


@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {


  products: Product[] = [];

  constructor(private productService:ProductService,
    private toastr:ToastrService,private searchService: SearchService,private route: ActivatedRoute){

    }
    ngOnInit(): void {
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
/*
    searchProductByName(productName:string) {
    this.productService.getProductByName(productName).subscribe(
      response => {
        console.log(response);
        this.products = response;
      },
      error => {
        this.toastr.error("No se encontraron productos");
        console.error(error);
      }
    )
  }
  */







}
