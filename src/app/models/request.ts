import { Chat } from "./chat";
import { CodePromo } from "./codePromo";

export class Request
{
    idRequest:number ; 
    title:string ; 
    content:string;
    evidence:string; 
    //client:Client
    //supplier:supplier
    codePromo:CodePromo ; 
    chats:Chat
}