import { Component, OnInit } from '@angular/core';
import { PurchaseOrder } from 'src/app/models/pruchase_order';
import { OrderService } from 'src/app/services/ordre.service';

@Component({
  selector: 'app-lis-offre',
  templateUrl: './lis-offre.component.html',
  styleUrls: ['./lis-offre.component.scss']
})
export class LisOffreComponent  implements OnInit {
  
  orders: PurchaseOrder[];
  
  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.orderService.listPurchaseOrder().subscribe(
      (data: PurchaseOrder[]) => {
        this.orders = data;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }
}