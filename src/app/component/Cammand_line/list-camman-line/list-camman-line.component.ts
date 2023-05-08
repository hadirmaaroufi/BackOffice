import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommandLine } from 'src/app/models/cammand_line';
import { CommandeLineService } from 'src/app/services/cammand-line.service';

@Component({
  selector: 'app-list-camman-line',
  templateUrl: './list-camman-line.component.html',
  styleUrls: ['./list-camman-line.component.scss']
})
export class ListCammanLineComponent implements OnInit {

  commandLines: any;
  Product : any ;
  constructor(private commandLineService: CommandeLineService , private router: Router) { }

  ngOnInit(): void {
    this.getCommandLines();
    
  }

  getCommandLines(): void {
    this.commandLineService.getListCommandLine()
      .subscribe(data => 
        {this.commandLines = data 
        console.log(this.commandLines)
        });
  }

  deleteCommandLine(id: number): void {
    if (confirm('Are you sure you want to delete this command line?')) {
      this.commandLineService.deleteCommandLine(id)
        .subscribe(() => {
          console.log('Command line deleted successfully');
          this.commandLines = this.commandLines.filter(cl => cl.idCommandeLine !== id);
        }, (error) => {
          console.error('Error deleting command line: ', error);
        });
    }
  }
  updateCommandLine(idCommandeLine: number) {
    this.router.navigate(['/edit-commend-line', idCommandeLine]);
  }
  

}