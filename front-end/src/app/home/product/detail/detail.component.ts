import { Component } from '@angular/core';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent {

  quantity:number = 1;
  product = {// Si categoria es igual a indumentaria aparecen los botones de talle
    category: ''
  };

  asCategoryClothing():boolean {//htieneCategoriaIndumentaria
    return this.product.category === 'indumentaria';
  }
  decrement():void{
    if(this.quantity > 1)
      this.quantity--;
  }
  increment():void{
    this.quantity++;
  }

}
