import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Blog } from 'src/app/models/blog';
import { BlogService } from 'src/app/services/blog.service';


@Component({
  selector: 'app-edit-bblog',
  templateUrl: './edit-bblog.component.html',
  styleUrls: ['./edit-bblog.component.scss']
})
export class EditBblogComponent implements OnInit {
  blogId: number;
  blog: Blog;

  constructor(private route: ActivatedRoute, private blogService: BlogService, private router: Router) { }

  ngOnInit(): void {
    this.blogId = this.route.snapshot.params['id'];
    this.blogService.getBlog(this.blogId).subscribe(
      data => {
        this.blog = data;
        
      },
      error => console.log(error)
    );
  }

  updateBlog() {
    this.blogService.updateBlog(this.blog).subscribe(
      data => {
        console.log(data);
        this.router.navigate(['list-blog']);
        this.gotoList();
      },
      error => console.log(error)
    );
  }
  onSubmit() {
    this.updateBlog();    
  }
  gotoList() {
    this.router.navigate(['/list-blog']);
  }
}
