import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TransactionData } from 'src/app/model/transaction-data';

@Component({
  selector: 'app-succes-view',
  templateUrl: './succes-view.component.html',
  styleUrls: ['./succes-view.component.css']
})
export class SuccesViewComponent implements OnInit{
  transactionData: any; // Utiliza el tipo de dato adecuado para los datos de la URL

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.transactionData = params;
    });
  }

}
