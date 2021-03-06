import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatGridListModule, MatInputModule, MatButtonModule, MatCardModule, MatMenuModule, MatToolbarModule, MatIconModule } from '@angular/material';
import { MDBBootstrapModule } from 'angular-bootstrap-md'
import { Routes, RouterModule } from '@angular/router';
import { SlideshowModule } from 'ng-simple-slideshow';

import { InfiniteScrollModule } from 'ngx-infinite-scroll';

import { AppComponent } from './app.component';
import { ProductComponent } from './components/product/product.component';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';
import { HomeComponent } from './components/home/home.component'



import { DataService } from './services/data.service';
import { GrocerylistComponent } from './components/grocerylist/grocerylist.component';
import { GrocerylistproductComponent } from './components/grocerylist/grocerylistproduct/grocerylistproduct.component';

import { AuthenticationService } from './services/authentication.service';
import { GroceryListService } from './services/grocerylistsService.service';


const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'register', component: SignupComponent },
  { path: 'products', component: ProductComponent },
  { path: 'grocerylists', component: GrocerylistComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    GrocerylistComponent,
    GrocerylistproductComponent,
    SigninComponent,
    SignupComponent,
    HomeComponent
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
    MatInputModule,
    MatIconModule,
    MatGridListModule,
    InfiniteScrollModule,
    MDBBootstrapModule.forRoot(),
    SlideshowModule
  ],
  providers: [DataService, AuthenticationService, GroceryListService],
  bootstrap: [AppComponent]
})
export class AppModule { }