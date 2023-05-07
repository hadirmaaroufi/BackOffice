import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RequestService } from 'src/app/services/request.service';
import { Request } from 'src/app/models/request';
import { CodePromo } from 'src/app/models/codePromo';
import { Chat } from 'src/app/models/chat';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-edit-request',
  templateUrl: './edit-request.component.html',
  styleUrls: ['./edit-request.component.scss']
})
export class EditRequestComponent  implements OnInit {

addRequestForm: FormGroup;
request : Request ;

  constructor(
    private formBuilder: FormBuilder,
    private requestService: RequestService,
    private router : Router ,
    private route: ActivatedRoute 
  ) { }

  ngOnInit(): void {
   
    this.addRequestForm = this.formBuilder.group({
      title: ['', Validators.required],
      content: ['', Validators.required],
      evidence: ['', Validators.required],
      codePromo:['', Validators.required],
    });
    const id= +this.route.snapshot.paramMap.get('id');
    console.log(id)
    this.requestService.getRequestById(id).subscribe(
      (req) => {
    this.request = req;
    this.request.idRequest = id ;
    },
    error => console.log(error)
    );
    
  }

  onSubmit(): void {

    this.requestService.updateRequest(this.request.idRequest, this.request).subscribe(() => {
      console.log('Request edited successfully!');
      // add any necessary redirect or alert here
      this.router.navigate(["/list-request"]); 
    });
  }

}