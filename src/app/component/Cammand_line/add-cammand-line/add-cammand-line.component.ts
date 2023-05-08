import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { response } from 'express';
import { CommandLine } from 'src/app/models/cammand_line';
import { Cart } from 'src/app/models/cart';
import { Produit } from 'src/app/models/produit';
import { CommandeLineService } from 'src/app/services/cammand-line.service';
import { CartService } from 'src/app/services/cart.service';
import { ProduitService } from 'src/app/services/product.service';


@Component({
  selector: 'app-add-cammand-line',
  templateUrl: './add-cammand-line.component.html',
  styleUrls: ['./add-cammand-line.component.scss']
})
export class AddCammandLineComponent  implements OnInit {
  commandLine: CommandLine = new CommandLine(); // initialize with parentheses
  addCommandLineForm!: FormGroup;
  productList: Produit[] = [];
  submitted = false;
  idCart: number;
  cartList: Cart[];
  constructor(
    private formBuilder: FormBuilder,
    private commandLineService: CommandeLineService,
    private productService: ProduitService,
    private CartService : CartService , 
    private router: Router
  ) {}

  ngOnInit(): void {
    this.productService.getProducts().subscribe(
      (response: Produit[]) => {
        this.productList = response;
      },
      (error: Error) => {
        console.log('Error fetching products: ' + error.message);
      },
  
    );
    this.CartService.getListCart().subscribe(
      (response: Cart[])=>
      {
        this.cartList = response ;
      },
      (error: Error) => {
        console.log('Error fetching products: ' + error.message);
      }
    );

    this.addCommandLineForm = this.formBuilder.group({
      quantity: ['', [Validators.required]],
      idProduct: ['', Validators.required] , 
      cart : ['', Validators.required] , 
    });
  }

  // convenience getter for easy access to form fields
  get f() {
    return this.addCommandLineForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    const commandLines = {
      quantity: this.commandLine.quantity,
      product: {
        idProduct: this.addCommandLineForm.value.idProduct , 
        
      } , 
      cart : this.addCommandLineForm.value.idCart ,
      idCommandeLine : this.commandLine.idCommandeLine ,
    };

    this.commandLineService.addCommandLine(commandLines, this.idCart).subscribe(
      (data : any) => {
        this.commandLine.idCommandeLine = data.idCommandeLine ; 
        // this.commandLine.produit.idProduct = data.product.idProduct ; 
        console.log(this.commandLine.idCommandeLine);
        console.log(commandLines.product.idProduct);
        console.log(data);

        this.commandLineService.assignProductToCommandeL( this.commandLine.idCommandeLine, [commandLines.product.idProduct]).subscribe(
          (data) => {
            console.log(data);
            
            console.log('Product assigned to command line');
            
          },

          (error: Error) => {
            console.log('Error assigning product to command line: ' + error.message);
          }
        );
       
        this.router.navigate(['/list-command-line']);
      },
      (error: Error) => {
        console.log('Error adding command line: ' + error.message);
      }
    );

 
}

  onCancel() {
    this.router.navigate(['/list-command-line']); // corrected component name
  }
}