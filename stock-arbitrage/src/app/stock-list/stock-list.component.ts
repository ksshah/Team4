import { Component, OnInit } from '@angular/core';
import { Stock } from '../stock';
import {StockDataService} from "../stock-data.service"
import {Router} from '@angular/router';
@Component({
  selector: 'app-stock-list',
  templateUrl: './stock-list.component.html',
  styleUrls: ['./stock-list.component.css']
})
export class StockListComponent implements OnInit {

  constructor(private stockdata:StockDataService,private router:Router) { }

  stocks:Stock[]=[];
  selectedst:Stock[]=[];
  a:number=0;
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
  Addtodatabase(event,stock){
    console.log(event.checked);
    if(event.checked){
      this.selectedst[this.a]=stock;
      this.a=this.a+1;
    }
    console.log(this.selectedst);
    console.log(stock);
  }
   save(){
     this.stockdata.savestocks(this.selectedst).subscribe();
   }
   profile(){
     this.router.navigateByUrl("/profile");
   }
}
