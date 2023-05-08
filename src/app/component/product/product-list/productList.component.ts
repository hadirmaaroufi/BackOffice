import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/models/produit';
import { ProduitService } from 'src/app/services/product.service';


@Component({
  selector: 'app-product',
  templateUrl: './productList.component.html',
  styleUrls: ['./productList.component.scss']
})
export class ProductComponent implements OnInit {

  produits: Produit[] = [];

  constructor(private produitService: ProduitService) { }

  ngOnInit(): void {
    this.produitService.getProducts().subscribe(data => {
      this.produits = data;
      console.log("aaaa")
    });
  }
  updateProduct(idProduct : number )
  {

  };
  deleteProduct( idProduct : number ) 
  {
    
  }
}
