import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CodePromo } from 'src/app/models/codePromo';
import { CodePromoService } from 'src/app/services/code-promo.service';

@Component({
  selector: 'app-lis-promo-code',
  templateUrl: './lis-promo-code.component.html',
  styleUrls: ['./lis-promo-code.component.scss']
})
export class LisPromoCodeComponent implements OnInit {

  promocodes: CodePromo[] = [];
  idCode : number ; 
  constructor(
    private codePromoService: CodePromoService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.codePromoService.getAllCodePromos().subscribe(
      data => {
        this.promocodes = data;
        console.log(data)
      },
      error => console.log(error)
    );
  }

  
  updatePromocode(idCode: number )
{
  this.router.navigate(['/edit-promocode',idCode]);
   
}
}
