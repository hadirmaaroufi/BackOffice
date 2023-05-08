import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommentService } from 'src/app/services/comment.service';
import { Comment } from '../../../models/comment';
@Component({
  selector: 'app-list-comment',
  templateUrl: './list-comment.component.html',
  styleUrls: ['./list-comment.component.scss']
})
export class ListCommentComponent {


  comments: Comment[];

  constructor(private commentService: CommentService , private router : Router) { }

  ngOnInit(): void {
    this.getComments();
  }

  getComments(): void {
    this.commentService.getAllComments()
      .subscribe(comments => this.comments = comments);
  }
  deleteCom(id: number): void {
    if (confirm("Are you sure you want to delete this comment?")) {
    this.commentService.removeComment(id).subscribe(() => {
      this.comments = this.comments.filter(comments => comments.idComment !== id);
    });
  }}
  updateCom(id: number) {
    this.router.navigate(['/edit-comment',id]);
  }
}