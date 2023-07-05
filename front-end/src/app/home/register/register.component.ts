import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserDto } from 'src/app/model/user-dto';
import { AuthService } from 'src/app/services/user/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  name!:string;
  lastName!:string;
  phoneNumber!:string;
  email!:string;
  password!:string;
  confirmPassword: string = '';

  constructor(private authService: AuthService,
    private toastr: ToastrService,
    private router: Router){}

    ngOnInit(): void {}

  submitForm():void{
    const dto = new UserDto(this.name, this.lastName, this.phoneNumber, this.email, this.password);
    if(dto.password !== this.confirmPassword){
      this.toastr.error('Error','las contraseñas no coinciden', { timeOut: 3000, positionClass: 'toast-top-center' });
      return;
    }
    this.authService.register(dto).subscribe(
      data =>{
        console.log(data);
        this.toastr.success(data.message, 'Registro OK', { timeOut: 5000, positionClass: 'toast-top-center'});
        this.router.navigate(['/login']);
      },
      err =>{
        console.log(err);
        this.toastr.error(err.error.message, 'Error', { timeOut: 5000, positionClass: 'toast-top-center'});
      }
    )

  }
}
