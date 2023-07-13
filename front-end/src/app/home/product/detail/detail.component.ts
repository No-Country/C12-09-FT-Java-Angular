import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit{
  product!: Product;
  quantity:number = 1;
  nameCategory:string ='';

  constructor(private productService:ProductService,
  private activatedRoute: ActivatedRoute, private toast:ToastrService){}

  ngOnInit(): void {
    this.getProductById();

  }

  getProductById():void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.productService.getById(id).subscribe(
      data => {
        console.log(data);
        this.product = data;
        this.nameCategory = this.product.category;
      },
      err => {
        console.log(err);
        this.toast.error(err.error.message, 'Error', { timeOut: 3000, positionClass: 'toast-top-center'});
      }
    )
  }

  asCategoryClothing():boolean {//tieneCategoriaIndumentaria
    return this.nameCategory === 'Indumentaria';
  }

  decrement():void{
    if(this.quantity > 1)
      this.quantity--;
  }

  increment():void{
    this.quantity++;
  }

}
