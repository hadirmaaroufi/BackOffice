import { Component } from '@angular/core';
import { Delivery } from 'src/app/models/delivery';
import { ActivatedRoute, Router  } from '@angular/router';
import { DeliveryService } from 'src/app/services/delivery.service';

@Component({
  selector: 'app-edit-delivery',
  templateUrl: './edit-delivery.component.html',
  styleUrls: ['./edit-delivery.component.scss']
})
export class EditDeliveryComponent {

  idDelivery: number;
  delivery: Delivery;


  constructor(
    private route: ActivatedRoute,
    private deliveryService: DeliveryService,
    private router: Router,
  
  ) { }

  ngOnInit(): void {
    this.idDelivery = parseInt(this.route.snapshot.paramMap.get('id') ?? '0');
    this.loadDelivery();
  }


  loadDelivery(): void {
    this.deliveryService.getListDeliveryById(this.idDelivery).subscribe(
      delivery => {
        this.delivery = delivery;
        console.log("Delivery loaded successfully.", delivery);
      },
      error => console.log(error)
    );
  }


  updateDelivery(): void {
    this.deliveryService.updateDelivery(this.delivery).subscribe(
      response => {
        console.log("Delivery updated successfully.", response);
        this.router.navigate(['/list-delivery']);
      },

      error => console.log(error)
    );
  }


}
