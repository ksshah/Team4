import { BrowserModule } from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
import { StockListComponent } from './stock-list/stock-list.component';
import {HttpClientModule} from "@angular/common/http";
import { LoginComponent } from './login/login.component';
import {FormsModule} from '@angular/forms'
import { NgModule } from '@angular/core';
import {MatCheckboxModule, MatTableModule, MatPaginatorModule, MatSortModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProfileComponent } from './profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    StockListComponent,
    LoginComponent,
    ProfileComponent
    
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
        },
        {
          path:'profile',
          component:ProfileComponent
        }
      ]
    ),
    BrowserAnimationsModule,
    MatCheckboxModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule

  ],
  providers: [],
  exports:[MatCheckboxModule],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
}
