import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenService } from './services/token.service';

const AUTH = 'Authorization';
const BEARER = 'Bearer ';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private tokenService:TokenService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

     // Obtener el token de autenticación desde el local storage o donde lo tengas almacenado
     let intReq = request;
     const token = this.tokenService.getToken();
     if(token != null) {
       intReq = request.clone({headers: request.headers.set(AUTH, BEARER + token)});
     }
     return next.handle(intReq);
   }

}
