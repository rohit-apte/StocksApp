import { Component, OnInit } from '@angular/core';
import { StockService } from '../service/stock.service';
import { Stock } from './stock';

@Component({
  selector: 'app-stocks',
  templateUrl: './stocks.component.html',
  styleUrls: ['./stocks.component.scss']
})
export class StocksComponent implements OnInit {

  constructor(private stockService: StockService) { }
  
  stocks: Stock[];

  ngOnInit(): void {
    this.getStocks();
  }


  getStocks() {
    this.stockService.getStocks().subscribe(res => {
      this.stocks = res;
    });
  }
}
