import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Blog } from '../models/blog';

@Injectable({
  providedIn: 'root'
})
export class BlogService {
  private baseUrl = 'http://localhost:9000/bns';

  constructor(private http: HttpClient) { }
  
    getAllBlogs(): Observable<Blog[]> {
      return this.http.get<Blog[]>(`${this.baseUrl}/Blog/retrieve-all-Blogs`);
    }
  
    getBlog(id: number): Observable<Blog> {
      return this.http.get<Blog>(`${this.baseUrl}/Blog/retrieve-bLog/${id}`);
    }
  
    addBlog(blog: Blog): Observable<Blog> {
      return this.http.post<Blog>(`${this.baseUrl}/Blog/add-Blog`, blog);
    }
  
    updateBlog(blog: Blog): Observable<Blog> {
      return this.http.put<Blog>(`${this.baseUrl}/Blog/update-Blog`, blog);
    }
  
    removeBlog(id: number): Observable<void> {
      return this.http.delete<void>(`${this.baseUrl}/Blog/remove-Blog/${id}`);
    }
  }
  

