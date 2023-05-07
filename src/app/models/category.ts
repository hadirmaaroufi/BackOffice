import { Produit } from "./produit";

export class Category {
    idCategory!: number; 
    name!: string ;
    description!: string ;
    products?: Produit[];
}