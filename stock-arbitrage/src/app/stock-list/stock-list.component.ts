import { Component, OnInit } from '@angular/core';
import { Stock } from '../stock';
import {StockDataService} from "../stock-data.service"

@Component({
  selector: 'app-stock-list',
  templateUrl: './stock-list.component.html',
  styleUrls: ['./stock-list.component.css']
})
export class StockListComponent implements OnInit {

  constructor(private stockdata:StockDataService) { }

  stocks:Stock[]=[];
  selectedst:Stock[]=[];
  ngOnInit() {

    this.stockdata.getStocks().subscribe(
      data=>{
        this.stocks=data;
      },
      err=>{
        console.log("error in fetching data from :"+ err.url);

      }
      
    )
    
  }
   
  
}
