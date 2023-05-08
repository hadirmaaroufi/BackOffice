import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CodePromo } from 'src/app/models/codePromo';
import { CodePromoService } from 'src/app/services/code-promo.service';

@Component({
  selector: 'app-edit-promo-code',
  templateUrl: './edit-promo-code.component.html',
  styleUrls: ['./edit-promo-code.component.scss']
})
export class EditPromoCodeComponent implements OnInit {

promocode : CodePromo;
  
  constructor(
  private codePromoService: CodePromoService,
  private router: Router,
  private route: ActivatedRoute 
  ) { }
  
  ngOnInit(): void {
    const id= +this.route.snapshot.paramMap.get('id');
  this.codePromoService.getCodePromoById(id).subscribe(
    (promocode) => {
  this.promocode = promocode;
  console.log("aaaa" ,promocode )
  },
  error => console.log(error)
  );
  }
  
  onSubmit(): void {
  this.codePromoService.updateCodePromo(this.promocode.idCode, this.promocode).subscribe(
  data => {
  this.router.navigate(['list-promocode']);
  },
  error => console.log(error)
  );
  }
  
  }