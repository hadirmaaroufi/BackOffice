import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../models/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private baseUrl = 'http://localhost:9000/bns/Category';

  constructor(private http: HttpClient) { }

  getCategorys(): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.baseUrl}/retrieve-all-Categorys`);
  }

  retrieveCategory(idCategory: number): Observable<Category> {
    return this.http.get<Category>(`${this.baseUrl}/retrieve-Category/${idCategory}`);
  }

  addCategory(category: Category): Observable<Category> {
    return this.http.post<Category>(`${this.baseUrl}/add-Category`, category);
  }

  removeCategory(categoryId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/remove-Category/${categoryId}`, { responseType: 'text' });
  }

  updateCategory(category: Category): Observable<boolean> {
    return this.http.put<boolean>(`${this.baseUrl}/update-Category`, category);
  }

  affecterProduitACategorie(idCategorie: number, idProduit: number): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/${idCategorie}/produits/${idProduit}`, null);
  }

  getClientIp(): Observable<string> {
    return this.http.get<string>(`${this.baseUrl}/client-ip`);
  }
}
