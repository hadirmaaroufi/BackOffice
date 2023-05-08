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
    deliverer: Delivery;
  }
  export enum DeliveryStatus {
    PENDING = 'PENDING',
    IN_TRANSIT = 'IN_TRANSIT',
    DELIVERED = 'DELIVERED',
    CANCELED = 'CANCELED'
  }