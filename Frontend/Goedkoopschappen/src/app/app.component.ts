import { Component, OnInit } from '@angular/core';

import { DataService } from '../app/services/data.service';
import { Product } from './components/models/product';
import { NgForm } from '@angular/forms/src/directives/ng_form';
import { ProductComponent } from './components/product/product.component';

import { GroceryList } from './components/models/grocerylist.model';




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'app';
  products: Product[];
  searchString: string;
  grocerylist: GroceryList;
  grocerylists:GroceryList[];


  constructor() {}
  ngOnInit(){}

  

}
