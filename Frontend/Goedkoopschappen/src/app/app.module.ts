import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatGridListModule, MatInputModule, MatButtonModule, MatCardModule, MatMenuModule, MatToolbarModule, MatIconModule, MatSidenavModule, MatCheckboxModule } from '@angular/material';
import { MDBBootstrapModule } from 'angular-bootstrap-md'
import { Routes, RouterModule } from '@angular/router';

import { InfiniteScrollModule  } from 'ngx-infinite-scroll';

import { AppComponent } from './app.component';
import { ProductComponent } from './components/product/product.component';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';



import { DataService } from './services/data.service';
import { GrocerylistComponent } from './components/grocerylist/grocerylist.component';
import { GrocerylistproductComponent } from './components/grocerylist/grocerylistproduct/grocerylistproduct.component';

import { AuthenticationService } from './services/authentication.service'


const appRoutes: Routes = [
   {path: '', component:SignupComponent },
   {path: 'products', component:ProductComponent } 
];

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    GrocerylistComponent,
    GrocerylistproductComponent,
    SigninComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatMenuModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    MatCheckboxModule,
    MatInputModule,
    MatGridListModule,
    InfiniteScrollModule,
    MDBBootstrapModule.forRoot(),
  ],
  providers: [DataService, AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }