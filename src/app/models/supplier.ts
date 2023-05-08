import { Blog } from "./blog";
import { Shop } from "./shop";
import { AccountStatus } from "./user";

export interface Supplier {
    id: number;
    firstName: string;
    lastName: string;
    photo: string;
    phoneNumber: number;
    email: string;
    username: string;
    password: string;
    isActive: boolean;
    accountStatus: AccountStatus;
    shops: Shop[];
    blogs: Blog[];
    requests: Request[];
  }