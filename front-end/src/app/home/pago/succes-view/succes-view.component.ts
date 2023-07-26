import { Component } from '@angular/core';

@Component({
  selector: 'app-succes-view',
  templateUrl: './succes-view.component.html',
  styleUrls: ['./succes-view.component.css']
})
export class SuccesViewComponent {
  fechaActual!: Date;
  nombreMes!: string;


  constructor() {
    // Obtenemos la fecha actual al instanciar el componente
    this.fechaActual = new Date();
    this.nombreMes = this.fechaActual.toLocaleString('default', { month: 'long' });

  }


}
