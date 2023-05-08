import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Delivery } from '../models/delivery';

@Injectable({
  providedIn: 'root'
})
export class DeliveryService {

  private baseUrl = 'http://localhost:9000/bns/DeliveryController';

  constructor(private http: HttpClient) { }

  addDelivery(delivery: Delivery): Observable<Delivery> {
    return this.http.post<Delivery>(`${this.baseUrl}/addDelivery`, delivery);
  }

  updateDelivery(delivery: Delivery): Observable<Delivery> {
    return this.http.put<Delivery>(`${this.baseUrl}/updateDelivery`, delivery);
  }

  deleteDelivery(id: number): Observable<Delivery> {
    return this.http.put<Delivery>(`${this.baseUrl}/deleteDelivery/${id}`, null);
  }

  getListDelivery(): Observable<Delivery[]> {
    return this.http.get<Delivery[]>(`${this.baseUrl}/GetListDelivery`);
  }

  getListDeliveryById(id: number): Observable<Delivery> {
    return this.http.get<Delivery>(`${this.baseUrl}/GetListDeliveryById/${id}`);
  }

  assignDelivererToDelivery(idDelivery: number, idDeliverer: number): Observable<void> {
    const params = {
      idDelivery: idDelivery.toString(),
      idDeliverer: idDeliverer.toString()
    };
    return this.http.put<void>(`${this.baseUrl}/assignDelivererToDelivery`, null, { params });
  }

  assignDeliveryToOrder(idOrder: number, idDelivery: number): Observable<void> {
    const params = {
      idOrder: idOrder.toString(),
      idDelivery: idDelivery.toString()
    };
    return this.http.put<void>(`${this.baseUrl}/assignDeliveryToOrder`, null, { params });
  }

  availableDelivery(id: number): Observable<string> {
    return this.http.get<string>(`${this.baseUrl}/availableDelivery/${id}`);
  }

}
