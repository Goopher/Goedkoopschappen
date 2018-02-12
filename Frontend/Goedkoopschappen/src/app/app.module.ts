import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http'
import { FormsModule } from '@angular/forms'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatGridListModule, MatInputModule, MatButtonModule, MatCardModule, MatMenuModule, MatToolbarModule, MatIconModule, MatSidenavModule, MatCheckboxModule } from '@angular/material';
import { MDBBootstrapModule } from 'angular-bootstrap-md'

import { InfiniteScrollModule  } from 'ngx-infinite-scroll';

import { AppComponent } from './app.component';
import { ProductComponent } from './components/product/product.component';



import { DataService } from './services/data.service';



@NgModule({
  declarations: [
    AppComponent,
    ProductComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
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
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }