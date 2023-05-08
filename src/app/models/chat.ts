import { CodePromo } from "./codePromo";
import { Request } from "./request";
export class Chat {
    id: number;
    request: Request;
     codePromo: CodePromo;
    sender: string;
    recipient: string;
    message: string;
    sentAt: Date;

  }
  