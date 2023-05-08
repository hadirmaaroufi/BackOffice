import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Forum } from 'src/app/models/forum';
import { ForumService } from 'src/app/services/forum.service';

@Component({
  selector: 'app-add-forum',
  templateUrl: './add-forum.component.html',
  styleUrls: ['./add-forum.component.scss']
})
export class AddForumComponent  implements OnInit {

  forum: Forum = new Forum();

  constructor(private forumService: ForumService, private router: Router) { }

  ngOnInit(): void {
  }

  addForum(): void {
    this.forumService.addForum(this.forum)
      .subscribe(() => {
        this.router.navigate(['/list-forum']);
      });
  }

}