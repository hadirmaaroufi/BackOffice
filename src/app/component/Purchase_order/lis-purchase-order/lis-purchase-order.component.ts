import { Component, OnInit } from '@angular/core';
import { PurchaseOrder } from 'src/app/models/pruchase_order';
import { OrderService } from 'src/app/services/ordre.service';

@Component({
  selector: 'app-lis-purchase-order',
  templateUrl: './lis-purchase-order.component.html',
  styleUrls: ['./lis-purchase-order.component.scss']
})
export class LisPurchaseOrderComponent implements OnInit {
  orders: PurchaseOrder[] = [];

  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.loadOrders();
  }

  loadOrders(): void {
    this.orderService.listPurchaseOrder().subscribe(
      data => {
        this.orders = data;
      },
      error => {
        console.log(error);
      }
    );
  }
  
  updateOrder(idOrder: number){
    
  }

  deleteOrder(idOrder: number){
    
  }

}