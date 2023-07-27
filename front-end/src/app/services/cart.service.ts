import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  public products = [];
  public cartItemList: any = [];
  public productList = new BehaviorSubject<any>([]);
  cartURL = environment.apiResrURL + '/cart/';
  constructor(private httpClient:HttpClient) { }

  addProductToCart(cartId: number, productId: number): Observable<any> {
    const url = this.cartURL + cartId + '/products';
    // Enviar el productId como parte de la URL utilizando HttpParams
    let params = new HttpParams();
    params = params.append('productId', productId.toString());

    return this.httpClient.put(url, null, { params: params });
  }
  getProduct(){
    return this.productList.asObservable();
  }

  setProduct(product : any){
    this.cartItemList.push(...product);
    this.products.next(product);
  }
  addToCart(product : any){
    this.cartItemList.push(product);
    this.products.next(this.cartItemList);
    this.getTotalPrice();
    console.log(this.cartItemList)
  }
  getTotalPrice() : number{
    let grandTotal = 0;
    this.cartItemList.map((a:any)=>{
      grandTotal += a.total;
    })
    return grandTotal;
  }
  removeCartItem(product: any){
    this.cartItemList.map((a:any, index:any)=>{
      if(product.id=== a.id){
        this.cartItemList.splice(index,1);
      }
    })
    this.products.next(this.cartItemList);
  }
  removeAllCart(){
    this.cartItemList = []
    this.products.next(this.cartItemList);
  }
}
