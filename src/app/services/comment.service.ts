import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Comment } from '../models/comment';
@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private baseUrl = 'http://localhost:9000/bns/Comment';

  constructor(private http: HttpClient) { }

  getAllComments(): Observable<Comment[]> {
    return this.http.get<Comment[]>(`${this.baseUrl}/retrieve-all-Comments`);
  }

  getCommentById(id: number): Observable<Comment> {
    return this.http.get<Comment>(`${this.baseUrl}/comments/${id}`);
  }

  addComment(comment: Comment): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    return this.http.post<any>(`${this.baseUrl}/add-comment`, comment, httpOptions);
  }

  removeComment(id: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/${id}`);
  }

  updateComment(id: number, comment: Comment): Observable<Comment> {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    return this.http.put<Comment>(`${this.baseUrl}/comments/${id}`, comment, httpOptions);
  }

}
