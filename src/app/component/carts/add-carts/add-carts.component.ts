import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from 'src/app/models/cart';
import { Produit } from 'src/app/models/produit';
import { CartService } from 'src/app/services/cart.service';
import { ProduitService } from 'src/app/services/product.service';

@Component({
  selector: 'app-add-carts',
  templateUrl: './add-carts.component.html',
  styleUrls: ['./add-carts.component.scss']
})
export class AddCartsComponent implements OnInit {

  produitList: Produit[] = [];
  cart: Cart = new Cart();
  produitId: number;
  quantity: number;
  idCommandeLine:number ; 
  constructor(
    private produitService: ProduitService,
    private cartService: CartService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.produitService.getProducts().subscribe(
      data => {
        this.produitList = data;
      },
      error => console.log(error)
    );
  }

  addCart(): void {
    this.cartService.saveCart(this.cart).subscribe(
      data => {
        console.log(data);
        this.router.navigate(['/list-carts']);
      },
      error => console.log(error)
    );
  }

  assignCommandLineToCart(idCommandLine: number, idCart: number) {
    this.cartService.assignCommandeLineToCart(idCommandLine, idCart)
      .subscribe(() => {
        console.log('Command line assigned to cart successfully');
      }, (error) => {
        console.error('Error assigning command line to cart: ', error);
      });
  }
}