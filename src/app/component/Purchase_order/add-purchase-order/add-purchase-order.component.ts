import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Cart } from 'src/app/models/cart';
import { Delivery } from 'src/app/models/delivery';
import { Payment } from 'src/app/models/payment';
import { PaymentMethod, PurchaseOrder } from 'src/app/models/pruchase_order';
import { CartService } from 'src/app/services/cart.service';
import { OrderService } from 'src/app/services/ordre.service';

@Component({
  selector: 'app-add-purchase-order',
  templateUrl: './add-purchase-order.component.html',
  styleUrls: ['./add-purchase-order.component.scss']
})
export class AddPurchaseOrderComponent implements OnInit {
  orderForm: FormGroup;
  submitted = false;
  cartId: number;
  delivery: Delivery = new Delivery();
  payment: Payment = new Payment();
  purchaseOrder: PurchaseOrder = new PurchaseOrder();
  paymentMethods = Object.values(PaymentMethod);
  
  constructor(private formBuilder: FormBuilder, private orderService: OrderService,
  private cartService: CartService, private router: Router) { }
  
  ngOnInit(): void {
    this.cartService.getListCart().subscribe((carts: Cart[]) => {
      this.cartId = carts[0].idCart;
    });
  }
  
  get f() { return this.orderForm.controls; }
  savePurchaseOrder() {
    console.log("aaaaaaaaa")
    this.orderService.addPurchaseOrder(this.purchaseOrder, this.cartId)
      .subscribe(data => {
        console.log(data);
        this.router.navigate(['list-purchaseOrder']);
      }, error => console.log(error));
      console.log("aaaaaaaaa", this.purchaseOrder);
      this.router.navigate(['list-purchase-order']);
  }
  onSubmit() {
    this.savePurchaseOrder();
    this.router.navigate(['list-purchase-order']);
  }
}

  

  