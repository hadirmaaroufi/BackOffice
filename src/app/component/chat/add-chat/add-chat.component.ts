import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Chat } from 'src/app/models/chat';
import { CodePromo } from 'src/app/models/codePromo';
import { ChatService } from 'src/app/services/chat.service';
import { CodePromoService } from 'src/app/services/code-promo.service';

@Component({
  selector: 'app-add-chat',
  templateUrl: './add-chat.component.html',
  styleUrls: ['./add-chat.component.scss']
})
export class AddChatComponent implements OnInit {

  chatForm: FormGroup;
  codepromoList : CodePromo[] = [];
  idcode: any ; 
  constructor
  (private formBuilder: FormBuilder, 
    private chatService: ChatService , 
    private router :Router,
    private codePromoService : CodePromoService ,
    ) { }

  ngOnInit(): void {
    this.codePromoService.getAllCodePromos().subscribe(
      data =>
      {
        this.codepromoList = data
      },
      error => console.log(error)
      );
    this.chatForm = this.formBuilder.group({
      message: ['', Validators.required],
      sender: ['', Validators.required],
      recipient: ['', Validators.required],
      idcode: ['', Validators.required]
    });
  }

  onSubmit(): void {
    const chat: Chat = this.chatForm.value as Chat;
    chat.sentAt = new Date();
    chat.codePromo = this.idcode;
    this.chatService.addChat(chat).subscribe(
      response => {
        console.log(response);
        this.chatForm.reset();
        
      },
      error => {
        console.log(error);
      }
    );
    this.router.navigate(['list-chat']);
  }

}