import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Chat } from 'src/app/models/chat';
import { PurchaseOrder } from 'src/app/models/pruchase_order';
import { ChatService } from 'src/app/services/chat.service';
import { OrderService } from 'src/app/services/ordre.service';

@Component({
  selector: 'app-edit-purchase-order',
  templateUrl: './edit-purchase-order.component.html',
  styleUrls: ['./edit-purchase-order.component.scss']
})
export class EditPurchaseOrderComponent implements OnInit {

Order : PurchaseOrder ; 
catID : number ;
  constructor(private OrderService: OrderService, private route: ActivatedRoute , private router : Router) {}

  ngOnInit() {
    this.catID = this.route.snapshot.params['id'];
    this.OrderService.listOrderById(this.catID)
      .subscribe(Order => {
        this.Order = Order;
        console.log(Order)
      }, error => {
        console.log(error);
      });
  }

  onSubmit() {
    this.OrderService.updatePurchaseOrder(this.Order)
      .subscribe(order => {
        this.router.navigate(['/list-purchaseOrder']);
      }, error => {
        console.log(error);
      });
  }

}
