import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/user/auth.service';
import { Login } from 'src/app/model/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isLogged = false;
  isLogginFail = false;
  email = '';
  password = '';
  errMsj = '';

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.isLogged = this.authService.getIsLoggedIn();
    this.isLogginFail = false;
  }


  onLogin(): void {
    const loginUser: Login = {
      email: this.email,
      password: this.password
    };

    this.authService.login(loginUser).subscribe(
      () => {
        this.isLogged = true;
        this.isLogginFail = false;
        console.log("loqueo exitoso");
        this.router.navigate(['']);
      },
      (err) => {
        this.isLogged = false;
        this.isLogginFail = true;
        this.errMsj = err.error.mensaje;
        console.log(this.errMsj);
      }
    );
  }

  login(): void{

  }

  register(): void {
    this.router.navigate(['/register']);
  }
}
