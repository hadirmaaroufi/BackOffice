import { Cart } from "./cart";
import { Delivery } from "./delivery";
import { Payment } from "./payment";

export class PurchaseOrder {
    idOrder: number;
    reference: string;
    paymentMethod: PaymentMethod;
    orderPrice: number;
    tax: number;
    date: Date;
    discountCode: string;
    address: string;
    phoneNumber: string;
    mail: string;
    cart: Cart;
    delivery: Delivery;
    payment: Payment;
  }
  export enum PaymentMethod {
    ON_LINE = 'ON_LINE',
    CASH = 'CASH',
   
  }