import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CommandLine } from '../models/cammand_line';

@Injectable({
  providedIn: 'root'
})
export class CommandeLineService {


  private baseUrl = 'http://localhost:9000/bns/CommandeLineController';

  constructor(private http: HttpClient) { }

  addCommandLine(commandLine: CommandLine, idCart: number): Observable<CommandLine> {
    return this.http.post<CommandLine>(`${this.baseUrl}/addCommandLine/${idCart}`, commandLine);
  }

  assignProductToCommandeL(ligneCommende: number, idProduct: number[]): Observable<void> {
    return this.http.put<void>(`${this.baseUrl}/AffecterProduit-LC/${ligneCommende}`, idProduct);
  }

  updateCommandLine(commandLine: CommandLine): Observable<CommandLine> {
    return this.http.put<CommandLine>(`${this.baseUrl}/updateCommandLine`, commandLine);
  }

  deleteCommandLine(id: number): Observable<CommandLine> {
    return this.http.put<CommandLine>(`${this.baseUrl}/deleteCommandLine/${id}`, {});
  }

  getListCommandLine(): Observable<CommandLine[]> {
    return this.http.get<CommandLine[]>(`${this.baseUrl}/GetListCommandLine`);
  }

  getListCommandLineById(id: number): Observable<CommandLine> {
    return this.http.get<CommandLine>(`${this.baseUrl}/GetListCommandLineById/${id}`);
  }
}