import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cart } from 'src/app/models/cart';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-edit-carts',
  templateUrl: './edit-carts.component.html',
  styleUrls: ['./edit-carts.component.scss']
})
export class EditCartsComponent implements OnInit {

  cart: Cart;

  constructor(private cartService: CartService, private route: ActivatedRoute , private router: Router) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.cartService.getListCartById(id).subscribe((cart) => {
      this.cart = cart;
    });
  }

  onSubmit(): void {
    this.cartService.updateCart(this.cart).subscribe(() => {
      console.log('Cart updated successfully');
      this.gotoList();
    }, (error) => {
      console.error('Error updating cart: ', error);
    });
  }
  gotoList() {
    this.router.navigate(['/list-carts']);
  }
}