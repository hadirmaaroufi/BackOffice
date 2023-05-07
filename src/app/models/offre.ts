import { User } from "./user";

export class PromoCode {
    id: number;
    code: string;
    amount: number;
    createDate: Date;
    expirationDate: Date;
    user: User;
  }
  
