import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Forum } from '../models/forum';

@Injectable({
  providedIn: 'root'
})
export class ForumService {

  constructor(private http: HttpClient) { }
  private apiUrl = 'http://localhost:9000/bns/forum';
  getAllForums(): Observable<Forum[]> {
    return this.http.get<Forum[]>(`${this.apiUrl}/retrieve-all-forums`);
  }
  
  getForum(id: number): Observable<Forum> {
    return this.http.get<Forum>(`${this.apiUrl}/retrieve-forum/${id}`);
  }
  
  addForum(forum: Forum): Observable<Forum> {
    return this.http.post<Forum>(`${this.apiUrl}/add-forum`, forum);
  }
  
  removeForum(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/remove-forum/${id}`);
  }
  
  updateForum(forum: Forum): Observable<Forum> {
    return this.http.put<Forum>(`${this.apiUrl}/update-forum`, forum);
  }
  
  searchForums(keyword: string): Observable<Forum[]> {
    return this.http.get<Forum[]>(`${this.apiUrl}/search/${keyword}`);
  }
  
}
