import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommentService } from 'src/app/services/comment.service';
import { Comment } from '../../../models/comment';
import { ForumService } from 'src/app/services/forum.service';
@Component({
  selector: 'app-add-comment',
  templateUrl: './add-comment.component.html',
  styleUrls: ['./add-comment.component.scss']
})
export class AddCommentComponent {
  commentId: number;
  forumId: number;
  comment: Comment = new Comment();
  submitted = false;
  id1:any;
  forum:any;
  constructor(private commentService: CommentService, private router :Router, private route : ActivatedRoute,private forumService:ForumService) { }
  ngOnInit(): void {
  this.id1 = this.route.snapshot.paramMap.get("id");
  this.forumService.getForum(this.id1).subscribe(
    res=>{
      this.forum=res
    }
  ) 
} 



  saveComment(): void {
    const comment = {
      idComment: this.comment.idComment,
      content: this.comment.content,
      createdAt: this.comment.createdAt,
      client: this.comment.client,
      forum: this.comment.forum
    };
    const toSubmit={
      content:this.comment.content,
      createdAt: new Date()
    }
    console.log(comment);

    this.commentService.addComment(toSubmit,this.id1)
      .subscribe(res=>{
        console.log(comment)
      });
        this.router.navigate(['list-comment']);
  }

  newComment(): void {
    this.submitted = false;
  }



}


