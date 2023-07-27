import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { PreferenceDto } from '../model/preference-dto';
import { ProductPayment } from '../model/product-payment';
import { Product } from '../model/product';
import { TransactionData } from '../model/transaction-data';

@Injectable({
  providedIn: 'root'
})
export class MercadoPagoServiceService {

  authURL = environment.apiResrURL + '/preferences/';

  constructor(private httpClient:HttpClient) { }

  createPreference(product:ProductPayment):Observable<PreferenceDto>{
    return this.httpClient.post<PreferenceDto>(this.authURL + 'create', product);
  }

  // Método para consumir el endpoint de tu backend y enviar los datos de la transacción
  sendTransactionData(): Observable<TransactionData> {
    return this.httpClient.get<TransactionData>(this.authURL + 'payment-response');
  }
}