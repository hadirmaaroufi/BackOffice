import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Forum } from 'src/app/models/forum';
import { ForumService } from 'src/app/services/forum.service';

@Component({
  selector: 'app-edit-forum',
  templateUrl: './edit-forum.component.html',
  styleUrls: ['./edit-forum.component.scss']
})
export class EditForumComponent  implements OnInit {
  forumId: number;
  forum: Forum;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private forumService: ForumService
  ) {}

  ngOnInit(): void {
    this.forumId = this.route.snapshot.params['id'];
    this.forumService.getForum(this.forumId).subscribe((forum) => {
      this.forum = forum;
    });
  }

  onSave(): void {
    this.forumService.updateForum(this.forum).subscribe(() => {
      this.router.navigate(['/list-forum']);
    });
  }
}