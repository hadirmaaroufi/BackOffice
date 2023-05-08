import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommandLine } from 'src/app/models/cammand_line';
import { Produit } from 'src/app/models/produit';
import { CommandeLineService } from 'src/app/services/cammand-line.service';

@Component({
  selector: 'app-edit-cammand-line',
  templateUrl: './edit-cammand-line.component.html',
  styleUrls: ['./edit-cammand-line.component.scss']
})
export class EditCammandLineComponent implements OnInit {
  commandLineId: number;
  commandLine: CommandLine;

  constructor(private route: ActivatedRoute, private router: Router, private commandLineService: CommandeLineService) { }

  ngOnInit() {

    this.commandLineId = this.route.snapshot.params['id'];
    
    this.commandLineService.getListCommandLineById(this.commandLineId)
      .subscribe(data => {
        console.log(data)
        this.commandLine = data;
      }, error => console.log(error));
  }

  updateCommandLine() {
    this.commandLineService.updateCommandLine(this.commandLine)
      .subscribe(data => console.log(data), error => console.log(error));

    this.gotoList();
  }

  onSubmit() {
    this.updateCommandLine();    
  }

  gotoList() {
    this.router.navigate(['/list-command-line']);
  }
}