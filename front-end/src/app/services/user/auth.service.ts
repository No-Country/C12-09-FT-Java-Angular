import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserDto } from 'src/app/model/user-dto';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authURL = environment.apiResrURL + '/auth/';

  constructor(private httpClient: HttpClient) { }

  public register(userDto: UserDto): Observable<any>{
    return this.httpClient.post<any>(this.authURL + 'register', userDto);
  }


}
