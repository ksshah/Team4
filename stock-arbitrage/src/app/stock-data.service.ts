import { Injectable } from '@angular/core';
import {HttpClient,HttpParams} from '@angular/common/http';
import {Http} from '@angular/http';
import {Observable} from 'rxjs'
import {Stock} from './stock'
import { User } from './user';
import {RequestOptions,Headers} from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class StockDataService {

  url:string="http://localhost:8080";
  private options = new RequestOptions({headers: new Headers({'Content-Type': 'application/json'})});
  constructor(private httpClient:HttpClient) { }

  getStocks(): Observable<Stock[]>{ 
    return this.httpClient.get<Stock[]>(this.url);  
  }
  
  sendforCheck(user: User):Observable<User>{
    return this.httpClient.post<User>(this.url+"/auth",user);
  }
  getpass(a:string,b:string):Observable<number>{
    const  params = new  HttpParams().set('U', a).set('P',b);
    return this.httpClient.get<number>(this.url+"/auth", {params});
  }
  //getResult():Observable<number>{
    //return this.httpClient.get<number>(this.url+"/auth/res");
  //}
  //create(){
    //return this.httpClient.get(this.url+"/create");
  //}
}
/**
 * 
 */