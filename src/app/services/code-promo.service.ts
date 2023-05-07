import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CodePromo } from '../models/codePromo';

@Injectable({
  providedIn: 'root'
})
export class CodePromoService {


  private baseUrl = 'http://localhost:9000/bns/codePromo';

  constructor(private http: HttpClient) { }

  createCodePromo(codePromo: CodePromo): Observable<CodePromo> {
    return this.http.post<CodePromo>(`${this.baseUrl}/create`, codePromo);
  }

  getAllCodePromos(): Observable<CodePromo[]> {
    return this.http.get<CodePromo[]>(`${this.baseUrl}/read`);
  }

  getCodePromoById(id: number): Observable<CodePromo> {
    return this.http.get<CodePromo>(`${this.baseUrl}/${id}`);
  }

  updateCodePromo(id: number, codePromo: CodePromo): Observable<CodePromo> {
    return this.http.put<CodePromo>(`${this.baseUrl}/update/${id}`, codePromo);
  }

  deleteCodePromo(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' });
  }

}