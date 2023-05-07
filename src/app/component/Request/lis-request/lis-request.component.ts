import { Component, OnInit } from '@angular/core';
import { RequestService } from 'src/app/services/request.service';
import { Request } from 'src/app/models/request';
import { Router } from '@angular/router';
@Component({
  selector: 'app-lis-request',
  templateUrl: './lis-request.component.html',
  styleUrls: ['./lis-request.component.scss']
})
export class LisRequestComponent  implements OnInit {

  requests: Request[] = [];

  constructor(private requestService: RequestService, private router : Router) { }

  ngOnInit(): void {
    this.requestService.getAllRequests().subscribe(data => {
      
      this.requests = data
      
    });
  }

 
  deleteRequest(id: number): void {
    this.requestService.deleteRequest(id).subscribe(() => {
      this.requests = this.requests.filter(request => request.idRequest !== id);
    });
  }
  updateRequest( id : number) : void 
  {
    this.router.navigate(["/edit-request" , id]); 
  }
}