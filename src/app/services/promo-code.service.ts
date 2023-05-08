import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PromoCode } from '../models/promocode';
import { PromoCodeCreateRequest } from '../models/PromoCodeCreateRequest';

@Injectable({
  providedIn: 'root'
})
export class PromoCodeService {

 

  constructor(private http: HttpClient) { }
  private apiUrl = 'http://localhost:9000/bns';
  createCode(promoCodeRequest: PromoCodeCreateRequest): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/PromoCodeController/create-code`, promoCodeRequest);
  }

  getAll(): Observable<PromoCode[]> {
    return this.http.get<PromoCode[]>(`${this.apiUrl}/PromoCodeController/getAll`);
  }

  getById(id: number): Observable<PromoCode> {
    return this.http.get<PromoCode>(`${this.apiUrl}/PromoCodeController/getBydId/${id}`);
  }

  deleteById(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/PromoCodeController/delete-code/${id}`);
  }

}