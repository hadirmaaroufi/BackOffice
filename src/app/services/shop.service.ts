import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Shop } from '../models/shop';

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  private baseUrl = 'http://localhost:9000/bns/Shop';

  constructor(private http: HttpClient) { }

  getShopsList(): Observable<Shop[]> {
    return this.http.get<Shop[]>(`${this.baseUrl}/retrieve-all-Shops`);
  }

  addShop(shop: Shop): Observable<Shop> {
    return this.http.post<Shop>(`${this.baseUrl}/add-Shop`, shop);
  }

  updateShop(shop: Shop): Observable<any> {
    return this.http.put(`${this.baseUrl}/update-Shop`, shop);
  }

  deleteShop(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/remove-Shop/${id}`, { responseType: 'text' });
  }
}
