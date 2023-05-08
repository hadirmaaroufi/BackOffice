import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Chat } from '../models/chat';

@Injectable({
  providedIn: 'root'
})
export class ChatService {

  
  private baseUrl = 'http://localhost:9000/bns/chat';

  constructor(private http: HttpClient) { }

  addChat(chat: Chat): Observable<Chat> {
    return this.http.post<Chat>(`${this.baseUrl}/creer`, chat);
  }

  getChatById(id: number): Observable<Chat> {
    return this.http.get<Chat>(`${this.baseUrl}/read/${id}`);
  }
  getAllChats(): Observable<Chat[]> {
    return this.http.get<Chat[]>(`${this.baseUrl}/read`);
  }


  updateChat(id: number, chat: Chat): Observable<Chat> {
    return this.http.put<Chat>(`${this.baseUrl}/update/${id}`, chat);
  }

  deleteChat(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`);
  }
}