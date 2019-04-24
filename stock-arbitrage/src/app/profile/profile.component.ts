import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { StockDataService } from '../stock-data.service';
import {Router} from '@angular/router';
import { Stock } from '../stock';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

   A:User=new User;
   st:Stock[]=[];
   u:string="";
   n:number=0;
  constructor(private service:StockDataService,private router:Router) { }

  ngOnInit() {
    this.A=this.service.getUser();
    this.u=this.A.username;
    console.log(this.u);
  }
  Logout(){
    this.service.setUser(null);
    this.router.navigateByUrl("/");
  }
  show(){
    this.service.showsStocks(this.A.userid).subscribe(
      data=>this.st=data
    );
    this.n=1;
    console.log(this.st);
  }
}
