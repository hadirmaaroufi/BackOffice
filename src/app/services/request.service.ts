import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RequestService {


  private baseUrl = 'http://localhost:9000/bns/requests';

  constructor(private http: HttpClient) { }

  getAllRequests(): Observable<Request[]> {
    return this.http.get<Request[]>(`${this.baseUrl}/read`);
  }

  getRequestById(id: number): Observable<Request> {
    return this.http.get<Request>(`${this.baseUrl}/getRequest/${id}`);
  }

  createRequest(request: Request): Observable<Request> {
    return this.http.post<Request>(`${this.baseUrl}/create`, request);
  }

  updateRequest(id: number, request: Request): Observable<Request> {
    return this.http.put<Request>(`${this.baseUrl}/updateRequest/${id}`, request);
  }

  deleteRequest(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' });
  }

}