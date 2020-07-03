import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stock } from '../stocks/stock';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
    providedIn: 'root'
})
export class StockService{
private globalUrl = '/api';
readonly STOCKS = '/stocks';
readonly STOCK = '/stock';
readonly DELIMETER = '/';
stockId: string;
constructor(
    private http: HttpClient,
    private snackBar: MatSnackBar
  ) {}

getStocks(): Observable<Stock[]> {
    return this.http.get<Stock[]>(this.globalUrl + this.STOCKS);
}



}