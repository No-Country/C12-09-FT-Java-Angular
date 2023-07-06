import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthResponse } from 'src/app/model/auth-response';
import { UserDto } from 'src/app/model/user-dto';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authURL = environment.apiResrURL + '/auth/';

  constructor(private httpClient: HttpClient) { }

  public register(userDto: UserDto): Observable<AuthResponse>{
    return this.httpClient.post<AuthResponse>(this.authURL + 'register', userDto);
  }


}
