import { PurchaseOrder } from "./pruchase_order";

export class Delivery {
    idDelivery: number;
    address: string;
    deliveryDate: Date;
    arrivalDate: Date;
    totalPrice: number;
    phoneNumber: string;
    deliveryStatus: DeliveryStatus;
    purchaseOrders: PurchaseOrder[];
    // deliverer: Delivery;
  }
  export enum DeliveryStatus {
    NotStarted = 'NotStarted',
    InProgress = 'InProgress',
    Delivered = 'Delivered'
  }