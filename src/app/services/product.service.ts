import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Produit } from '../models/produit';
@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  constructor(private http: HttpClient) { }
  private apiUrl = 'http://localhost:9000/bns/Product';
  httpOptions = {
    headers: new HttpHeaders({
    'Content-Type': 'multipart/form-data'
    })
    }
  getProducts(currency?: string): Observable<Produit[]> {
    const url = `http://localhost:9000/bns/Product/retrieve-all-Products`;
    const params: any = {};
    if (currency) {
      params.currency = currency;
    }
    return this.http.get<Produit[]>(url, { params });
  }
  
  retrieveProduct(productId: number): Observable<Produit> {
    const url = `${this.apiUrl}/retrieve-Product/${productId}`;
    return this.http.get<Produit>(url);
  }
  
  addProduct(product: Produit): Observable<Produit> {
    const url = `${this.apiUrl}/add-product/${product.idCategorie}`;

    return this.http.post<Produit>(url, product , this.httpOptions);
  }
  
  removeProduct(productId: number): Observable<void> {
    const url = `${this.apiUrl}/remove-Product/${productId}`;
    return this.http.delete<void>(url);
  }
  
  updateProduct(product: Produit): Observable<boolean> {
    const url = `${this.apiUrl}/update-Product`;
    return this.http.put<boolean>(url, product);
  }
  
  // convertCurrencies(conversionCurrency: ConversionCurrency): Observable<number> {
  //   const url = `${this.apiUrl}/currency-converter`;
  //   return this.http.post<number>(url, conversionCurrency);
  // }
  
  // getAllCurrencies(): Observable<Currency[]> {
  //   const url = `${this.apiUrl}/currencies`;
  //   return this.http.get<Currency[]>(url);
  // }
  
  promoteProduct(id: number, pourcentage: number): Observable<void> {
    const url = `${this.apiUrl}/promotion/${id}/${pourcentage}`;
    return this.http.put<void>(url, null);
  }
  
  getClientLocation(): Observable<{country: string, city: string}> {
    const url = `${this.apiUrl}/client-location`;
    return this.http.get<{country: string, city: string}>(url);
  }
  
}
