import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Shop } from 'src/app/models/shop';
import { ShopService } from 'src/app/services/shop.service';

@Component({
  selector: 'app-shop',
  templateUrl: './list-shop.component.html',
  styleUrls: ['./list-shop.component.scss']
})
export class ListShopComponent implements OnInit {

  shops: Shop[] = [];

  constructor(private shopService: ShopService, private router : Router) { }

  ngOnInit(): void {
    this.getShops();
 
  }

  getShops() {
    this.shopService.getShopsList().subscribe(
      (response: Shop[]) => {
        this.shops = response;
      },
      (error) => {
        console.log(error);
      }
    );
  }
  deleteShop(id: number): void {
    if (confirm("Are you sure you want to delete this category?")) {
    this.shopService.deleteShop(id).subscribe(() => {
      this.shops = this.shops.filter(shop => shop.idShop !== id);
    });
  }}
  UpdateShop(id: number) {
    this.router.navigate(['/edit-shops',id]);
  }
}
