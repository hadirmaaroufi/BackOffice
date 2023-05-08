import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PurchaseOrder } from 'src/app/models/pruchase_order';
import { OrderService } from 'src/app/services/ordre.service';

@Component({
  selector: 'app-lis-purchase-order',
  templateUrl: './lis-purchase-order.component.html',
  styleUrls: ['./lis-purchase-order.component.scss']
})
export class LisPurchaseOrderComponent implements OnInit {
  orders: PurchaseOrder[] = [];

  constructor(private orderService: OrderService , private router : Router) { }

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
    console.log(idOrder);
    this.router.navigate(['/edit-purchaseOrder', idOrder]);
  }
  

  deleteOrder(idOrder: number){
    
  }

}