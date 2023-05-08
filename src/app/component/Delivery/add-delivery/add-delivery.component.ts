import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { Delivery } from 'src/app/models/delivery';
import { DeliveryService } from 'src/app/services/delivery.service';

@Component({
  selector: 'app-add-delivery',
  templateUrl: './add-delivery.component.html',
  styleUrls: ['./add-delivery.component.scss']
})
export class AddDeliveryComponent implements OnInit {

  deliveryForm: FormGroup;
  protected aFormGroup: FormGroup;
  siteKey: string;
  constructor(
    private formBuilder: FormBuilder,
    private deliveryService: DeliveryService,
    private router: Router
   
  ) { 
    this.siteKey="6LerM94lAAAAAKOePozpssnKQw-qeoOtEFypSA4l";
  }

  ngOnInit(): void {
    this.aFormGroup = this.formBuilder.group({
      recaptcha: ['', Validators.required]
    });
    this.deliveryForm = this.formBuilder.group({
 
      address: ['', Validators.required],
      deliveryDate: ['', Validators.required],
      deliveryStatus: ['', Validators.required],

      phoneNumber: ['', Validators.required],
      arrivalDate : ['', Validators.required],
      totalPrice : ['', Validators.required],
    });
  }

  onSubmit(): void {
   
    this.deliveryService.addDelivery(this.deliveryForm.value).subscribe(() => {
      this.router.navigate(['/list-delivery']);
    });
  }

}