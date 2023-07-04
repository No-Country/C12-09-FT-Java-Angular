import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  onSubmit() {
    // Aquí puedes agregar la lógica para enviar los datos de inicio de sesión al servidor
    // y realizar las validaciones necesarias
    console.log('Usuario:', this.username);
    console.log('Contraseña:', this.password);
  }
}
