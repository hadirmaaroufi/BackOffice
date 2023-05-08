import { Component, OnInit } from '@angular/core';
import { Blog } from 'src/app/models/blog';
import { BlogService } from 'src/app/services/blog.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-bblog',
  templateUrl: './list-bblog.component.html',
  styleUrls: ['./list-bblog.component.scss']
})
export class ListBblogComponent implements OnInit {

    blogs: Blog[];
  
    constructor(private blogService: BlogService, private router: Router) { }
  
    ngOnInit(): void {
      this.blogService.getAllBlogs().subscribe(
        data => {this.blogs = data,
          
        console.log(this.blogs)
        error => console.log(error)
        });
    }
    deleteBlog(blogId: number) {
      this.blogService.removeBlog(blogId).subscribe(() => {
        // remove the deleted blog from the list of blogs
        this.blogs = this.blogs.filter(blog => blog.idBlog !== blogId);
      });
    }
    
    updateBlog(blogId: number) {
      this.router.navigate(['/edit-blog', blogId]);
    }
    
  }
  