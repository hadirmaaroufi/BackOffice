import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommentService } from 'src/app/services/comment.service';
import { Comment } from '../../../models/comment';

@Component({
  selector: 'app-edit-commento',
  templateUrl: './edit-commento.component.html',
  styleUrls: ['./edit-commento.component.scss']
})
export class EditCommentoComponent {

  idComment: number;
  comments: Comment;

  constructor(private route: ActivatedRoute, private router: Router,
    private commentService: CommentService) { }

  ngOnInit() {


    this.idComment = this.route.snapshot.params['id'];

    this.commentService.getCommentById(this.idComment)
      .subscribe(
        data => {
        console.log(data)
        this.comments = data;
      }, error => console.log(error));
  }

  updateComment() {
    this.commentService.updateComment(this.idComment, this.comments)
      .subscribe(data => {
        console.log(data);
        this.comments = new Comment();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateComment();
  }

  gotoList() {
    this.router.navigate(['list-comment']);
  }
}