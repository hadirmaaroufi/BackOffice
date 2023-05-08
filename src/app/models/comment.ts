import { Forum } from "./forum";

export class Comment {
    idComment: number;
    content: string;
    createdAt: Date;
    forum: Forum;
    client: number;}
