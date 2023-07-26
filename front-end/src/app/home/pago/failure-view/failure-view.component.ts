import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TransactionData } from 'src/app/model/transaction-data';

@Component({
  selector: 'app-failure-view',
  templateUrl: './failure-view.component.html',
  styleUrls: ['./failure-view.component.css']
})
export class FailureViewComponent {
  transactionData: any; // Utiliza el tipo de dato adecuado para los datos de la URL

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.transactionData = params;
    });
  }
}
