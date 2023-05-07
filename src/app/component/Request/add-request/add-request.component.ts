import { Component, OnInit } from '@angular/core';
import { RequestService } from 'src/app/services/request.service';
import { Request } from 'src/app/models/request';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ShopService } from 'src/app/services/shop.service';
@Component({
  selector: 'app-add-request',
  templateUrl: './add-request.component.html',
  styleUrls: ['./add-request.component.scss']
})
export class AddRequestComponent  {

  requestForum: FormGroup;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private requestService: RequestService
  ) { }

  ngOnInit(): void {
    this.requestForum = this.formBuilder.group({
      title: ['',[ Validators.required , Validators.minLength(4), Validators.maxLength(20)]],
      content: ['', Validators.required],
      evidence: ['']
    });
  }
 
  // convenience getter for easy access to form fields
  get f() { return this.requestForum.controls; }


  onSubmit() {
    this.submitted = true;
    console.log(this.requestForum)
    this.requestService.createRequest(this.requestForum.value).subscribe(data => console.log(data), err => console.log(err))
    if (this.requestForum.invalid) {
      return;
    }

    this.requestService.createRequest(this.requestForum.value).subscribe(() => {
      this.router.navigate(['/list-request']);
    });
  }

  onCancel() {
    this.router.navigate(['/list-request']);
  }
}