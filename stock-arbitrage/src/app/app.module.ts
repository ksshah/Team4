import { BrowserModule } from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
import { StockListComponent } from './stock-list/stock-list.component';
import {HttpClientModule} from "@angular/common/http";
import { LoginComponent } from './login/login.component';
import {FormsModule} from '@angular/forms'
import { NgModule } from '@angular/core';

@NgModule({
  declarations: [
    AppComponent,
    StockListComponent,
    LoginComponent
    
  ],
  imports: [
    BrowserModule,HttpClientModule,
    FormsModule,
    RouterModule.forRoot(
      [
        {
          path:'',
          component:LoginComponent
        },
        {
          path:'list',
          component:StockListComponent
        }
      ]
    )

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
}
