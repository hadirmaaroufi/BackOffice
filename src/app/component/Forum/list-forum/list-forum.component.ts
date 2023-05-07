import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ForumService } from 'src/app/services/forum.service';
import { Forum } from '../../../models/forum';

@Component({
selector: 'app-list-forum',
templateUrl: './list-forum.component.html',
styleUrls: ['./list-forum.component.scss']
})
export class ListForumComponent implements OnInit {

forums: Forum[];

constructor(private forumService: ForumService , private router : Router) { }

ngOnInit(): void {
this.getForums();
}

getForums(): void {
this.forumService.getAllForums()
.subscribe(forums => this.forums = forums);
}

deleteForum(id: number): void {
if (confirm("Are you sure you want to delete this forum?")) {
this.forumService.removeForum(id).subscribe(() => {
this.forums = this.forums.filter(forum => forum.idForum !== id);
});
}
}
updateForum(id: number) {
  this.router.navigate(['/edit-forum',id]);
}
}