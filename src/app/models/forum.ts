import { Comment } from "./comment";

export class Forum {
    idForum: number; 
    title: string ;
    content: string ;
    publicationDate: Date;
    client: string;
    comments : Comment;
}