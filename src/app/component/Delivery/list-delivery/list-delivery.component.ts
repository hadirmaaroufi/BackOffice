import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Delivery } from 'src/app/models/delivery';
import { DeliveryService } from 'src/app/services/delivery.service';

@Component({
  selector: 'app-list-delivery',
  templateUrl: './list-delivery.component.html',
  styleUrls: ['./list-delivery.component.scss']
})
export class ListDeliveryComponent implements OnInit {

  deliveries: Delivery[];

  constructor(private deliveryService: DeliveryService , private router : Router) { }

  ngOnInit(): void {
    this.getDeliveries();
  }

  getDeliveries(): void {
    this.deliveryService.getListDelivery().subscribe(deliveries => this.deliveries = deliveries);
  }

  deleteDelivery(id: number): void {
    this.deliveryService.deleteDelivery(id).subscribe(() => {
      this.deliveries = this.deliveries.filter(delivery => delivery.idDelivery !== id);
    });
  }

  updateDelivery(id : number )
  {
    this.router.navigate(['/edit-delivery',id]);
  }
}