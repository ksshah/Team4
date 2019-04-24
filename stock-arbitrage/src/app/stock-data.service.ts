import { Injectable } from '@angular/core';
import {HttpClient,HttpParams} from '@angular/common/http';
import {Http} from '@angular/http';
import {Observable, combineLatest} from 'rxjs'
import {Stock} from './stock'
import { User } from './user';
import {RequestOptions,Headers} from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class StockDataService {

  UserA:User=new User;
  url:string="http://localhost:8080";
  saveurl:string=this.url+"/save/";
  private options = new RequestOptions({headers: new Headers({'Content-Type': 'application/json'})});
  
  constructor(private httpClient:HttpClient) { }

  getStocks(): Observable<Stock[]>{ 
    return this.httpClient.get<Stock[]>(this.url);  
  }
 
  getpass(a:string,b:string):Observable<number>{
    const  params = new  HttpParams().set('U', a).set('P',b);
    return this.httpClient.get<number>(this.url+"/auth", {params});
  }
 
  savestocks(s:Stock[]){
    for(let i of s){
      console.log(i.srNo);
      this.saveurl=this.saveurl+i.srNo+",";
      console.log(this.saveurl);
    }
    this.saveurl=this.saveurl.substring(0,this.saveurl.length-1);
    console.log(this.saveurl+","+this.UserA.userid);
    s=null;
    return this.httpClient.get(this.saveurl+","+this.UserA.userid);
    
  }
  setUser(a:User){
    this.UserA=a;
    console.log(this.UserA);
  }
  getUser():User{
    return this.UserA;
  }

  showsStocks(d:number):Observable<Stock[]>{
    console.log(this.url+"/data/"+d)
    return this.httpClient.get<Stock[]>(this.url+"/data/"+d);
  }

}
/**
 * 
 */