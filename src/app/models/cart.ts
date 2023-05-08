import { CommandLine } from "./cammand_line";
import { Produit } from "./produit";


export class Cart {
  idCart: number;
  totalCart: number;
  commandLines: CommandLine[];
  product : Produit[];
}