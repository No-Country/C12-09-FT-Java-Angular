export class Product {

  name:string;
  description:string;
  price:number;
  stock:number;
  category:string;

  constructor(name:string,description:string,price:number,
    stock:number,category:string){
      this.name=name;
      this.description=description;
      this.price=price;
      this.stock=stock;
      this.category=category;
    }
}
