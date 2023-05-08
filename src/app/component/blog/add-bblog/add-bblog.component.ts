import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Blog } from 'src/app/models/blog';
import { BlogService } from 'src/app/services/blog.service';

@Component({
  selector: 'app-add-bblog',
  templateUrl: './add-bblog.component.html',
  styleUrls: ['./add-bblog.component.scss']
})
export class AddBblogComponent {

  blog: Blog = new Blog();
  submitted = false;

  constructor(private blogService: BlogService , private router :Router) { }

  ngOnInit(): void {
  }

  saveBlog(): void {
    const data = {
      title: this.blog.title,
      content: this.blog.content,
      publicationDate: this.blog.publicationDate,
      supplier: this.blog.supplier,
      isValid : this.blog.isValid,
      idBlog : this.blog.idBlog 
    };

    this.blogService.addBlog(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
        this.router.navigate(['list-blog']);
  }

  newBlog(): void {
    this.submitted = false;
    this.blog = new Blog();
  }

}