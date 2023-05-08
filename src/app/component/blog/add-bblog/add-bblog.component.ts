import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { Blog } from 'src/app/models/blog';
import { BlogService } from 'src/app/services/blog.service';

@Component({
  selector: 'app-add-bblog',
  templateUrl: './add-bblog.component.html',
  styleUrls: ['./add-bblog.component.scss']
})
export class AddBblogComponent {
  blogForm: FormGroup;
  blog: Blog = new Blog();
  submitted = false;

  constructor(private blogService: BlogService , private router :Router , private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.blogForm = this.formBuilder.group({
      title: ['',[ Validators.required , Validators.minLength(4), Validators.maxLength(20)]],
      publicationDate:  ['', Validators.required]
    });
  }
  get title() { return this.blogForm.get('title'); }
  get publicationDate() { return this.blogForm.get('publicationDate'); } 
  

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