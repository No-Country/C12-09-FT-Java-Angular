import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthResponse } from 'src/app/model/auth-response';
import { UserDto } from 'src/app/model/user-dto';
import { environment } from 'src/environments/environment';
import { Login } from 'src/app/model/login';
import { JwtDto } from 'src/app/model/jwt-dto';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authURL = environment.apiResrURL + '/auth/';

  constructor(private httpClient: HttpClient) { }

  public register(userDto: UserDto): Observable<any>{
    return this.httpClient.post<any>(this.authURL + 'create', userDto);
  }

  public login(loginUser: Login): Observable<JwtDto>{
    return this.httpClient.post<JwtDto>(this.authURL + 'login', loginUser)
  }

}
