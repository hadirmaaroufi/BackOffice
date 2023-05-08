import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PurchaseOrder } from '../models/pruchase_order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private baseUrl = 'http://localhost:9000/bns/OrderController';

  constructor(private http: HttpClient) { }

  addPurchaseOrder(order: PurchaseOrder, idCard: number): Observable<PurchaseOrder> {
    return this.http.post<PurchaseOrder>(`${this.baseUrl}/addOrder/${idCard}`, order);
  }

  updatePurchaseOrder(order: PurchaseOrder): Observable<PurchaseOrder> {
    return this.http.put<PurchaseOrder>(`${this.baseUrl}/updateOrder`, order);
  }

  listPurchaseOrder(): Observable<PurchaseOrder[]> {
    return this.http.get<PurchaseOrder[]>(`${this.baseUrl}/GetListOrders`);
  }

  listOrderById(id: number): Observable<PurchaseOrder> {
    return this.http.get<PurchaseOrder>(`${this.baseUrl}/GetListOrderById/${id}`);
  }

  totalOrdersTVA(idOrder: number): Observable<number> {
    return this.http.put<number>(`${this.baseUrl}/TotalOrdersTVA/${idOrder}`, {});
  }

  createCharge(token: string, idUser: number, idOrder: number): Observable<number> {
    return this.http.post<number>(`${this.baseUrl}/stripePayment/${token}/${idUser}/${idOrder}`, {});
  }

  generatePdfReport(): Observable<any> {
    return this.http.get(`${this.baseUrl}/orders/pdf`, { responseType: 'blob' });
  }
}
