import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../models/cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private baseUrl = 'http://localhost:9000/bns/CartController';

  constructor(private http: HttpClient) { }

  saveCart(cart: Cart): Observable<Cart> {
    return this.http.post<Cart>(`${this.baseUrl}/saveCart`, cart);
  }

  assignCommandeLineToCart(idCommandLine: number, idCart: number): Observable<void> {
    return this.http.put<void>(`${this.baseUrl}/assignCommandeLineToCart?idCommandLine=${idCommandLine}&idCart=${idCart}`, null);
  }

  updateCart(cart: Cart): Observable<Cart> {
    return this.http.put<Cart>(`${this.baseUrl}/updateCart`, cart);
  }

  deleteCart(id: number): Observable<Cart> {
    return this.http.put<Cart>(`${this.baseUrl}/deleteCart/${id}`, null);
  }

  getListCart(): Observable<Cart[]> {
    return this.http.get<Cart[]>(`${this.baseUrl}/GetListCart`);
  }

  getListCartById(id: number): Observable<Cart> {
    return this.http.get<Cart>(`${this.baseUrl}/GetListCartById/${id}`);
  }
}