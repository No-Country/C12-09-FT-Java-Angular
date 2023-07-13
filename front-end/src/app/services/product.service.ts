import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  authURL = environment.apiResrURL + '/products/';
  constructor(private httpClient:HttpClient) { }

  public getProductsForCategory(name:string): Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.authURL + 'category' + `/${name}`);
  }
}
