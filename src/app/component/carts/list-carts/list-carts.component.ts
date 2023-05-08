import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from 'src/app/models/cart';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-list-carts',
  templateUrl: './list-carts.component.html',
  styleUrls: ['./list-carts.component.scss']
})
export class ListCartsComponent implements OnInit {

  carts: Cart[];
  
  constructor(private cartService: CartService , private router : Router) { }
  
  ngOnInit() {
  this.getCarts();
  }
  
  getCarts(): void {
  this.cartService.getListCart()
  .subscribe(carts => this.carts = carts);
  }
  
  deleteCart(idCart: number): void {
  this.cartService.deleteCart(idCart)
  .subscribe(() => this.getCarts());
  }
  UpdateCart(id: number) {
    this.router.navigate(['/edit-carts',id]);
  }
  }