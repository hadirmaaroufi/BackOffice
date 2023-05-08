import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Chat } from 'src/app/models/chat';
import { ChatService } from 'src/app/services/chat.service';

@Component({
  selector: 'app-list-chat',
  templateUrl: './list-chat.component.html',
  styleUrls: ['./list-chat.component.scss']
})
export class ListChatComponent implements OnInit {
  chats: Chat[] = [];

  constructor(
    private chatService: ChatService ,
    
     private router: Router
    
     ) { }

  ngOnInit(): void {
   
    // Fetch list of chats
    this.chatService.getAllChats().subscribe(
      data => {
        this.chats = data;
        console.log("aaa", this.chats)
      },
      error => {
        console.log(error);
      }
    );
    }
    deleteChat(idChat: number) {
      this.chatService.deleteChat(idChat).subscribe(() => {
        // remove the deleted blog from the list of blogs
        this.chats = this.chats.filter(blog => blog.id !== idChat);
      });
    }
    
    updateChat(idChat: number) {
      this.router.navigate(['/edit-chat', idChat]);
    }
    
  }