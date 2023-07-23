import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { param } from 'jquery';

@Component({
  selector: 'app-payment-response',
  templateUrl: './payment-response.component.html',
  styleUrls: ['./payment-response.component.css']
})
export class PaymentResponseComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router){}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params =>{
      const status = params['status'];// Asume que el servidor envía el estado del pago como parámetro 'status'
      if (status === 'approved') {
        this.router.navigateByUrl('/payment/success'); // Redireccionar a la vista de éxito si el estado es 'approved'
      } else if (status === 'failure') {
        this.router.navigateByUrl('/payment/failure'); // Redireccionar a la vista de fallo si el estado es 'failure'
      } else if (status === 'pending') {
        this.router.navigateByUrl('/payment/pending'); // Redireccionar a la vista de pendiente si el estado es 'pending'
      } else {
        // En caso de que el estado no sea reconocido o falte información, puedes redireccionar a una página de error
        this.router.navigateByUrl('/error');//falta crear
      }
    });
  }

}
