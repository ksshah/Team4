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

  d:User=new User;
  //pass:number=0;

  constructor(private router:Router,private service:StockDataService) {
    
  }
  
  ngOnInit() {
  }
  Auth(myform){
    console.log(this.d);
    console.log("Values are: ",myform.value);
    this.service.getpass(this.d.username,this.d.password).subscribe(
      data=>this.d.userid=data,      
    );   
    console.log(this.d.userid); 
    if(this.d.userid!=null && this.d.userid!=0){
        this.d.isLogged=true;
        this.service.setUser(this.d);
        this.router.navigateByUrl("/list");        // if fail pass again
    }
    else if(this.d.userid==null){
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