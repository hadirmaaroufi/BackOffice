import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommandLine } from 'src/app/models/cammand_line';
import { Produit } from 'src/app/models/produit';
import { CommandeLineService } from 'src/app/services/cammand-line.service';
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

  constructor(
    private formBuilder: FormBuilder,
    private commandLineService: CommandeLineService,
    private productService: ProduitService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.productService.getProducts().subscribe(
      (response: Produit[]) => {
        this.productList = response;
      },
      (error: Error) => {
        console.log('Error fetching products: ' + error.message);
      }
    );

    this.addCommandLineForm = this.formBuilder.group({
      quantity: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      idProduct: ['', Validators.required]
    });
  }

  // convenience getter for easy access to form fields
  get f() {
    return this.addCommandLineForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    const commandLine = {
      quantity: this.addCommandLineForm.value.quantity,
      product: {
        idProduct: this.addCommandLineForm.value.idProduct
      }
    };

    this.commandLineService.addCommandLine(this.addCommandLineForm.value, this.idCart).subscribe(
      () => {
        this.router.navigate(['/list-command-line']); // corrected component name
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