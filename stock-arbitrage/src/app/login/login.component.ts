import { Component, OnInit } from '@angular/core';
import {StockDataService} from "../stock-data.service";
import { User } from '../user';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  u:User=new User;
  d:User=new User;
  P:string="";
  U:string="";
  pass:number=0;

  constructor(private router:Router,private service:StockDataService) {
    
  }
  
  ngOnInit() {
  }
  Auth(){

    this.d={username:this.U, password:this.P,isLogged:false};

    this.service.getpass(this.d.username,this.d.password).subscribe(
      data=>this.pass=data,      
    );    
    if(this.pass==1){
        this.d.isLogged=true;
        this.router.navigateByUrl("/list");        // if fail pass again
    }
    else if(this.pass==0){
        this.router.navigateByUrl("/");        //if success 
    }
  }

}
/**
 * Auth(){
 *  String s={}
    
  this.d.username=this.U;
  this.d.password=this.P;
  console.log(this.d.password)
  this.service.sendforCheck(this.d).subscribe(data=>{
    this.u=data;
  });
  
  }
  this.service.sendforCheck(this.d).subscribe(
            result => console.log(result),
        );
    }
 **/