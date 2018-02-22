import { Component, OnInit } from '@angular/core';

import { DataService } from '../app/services/data.service';
import { GroceryListService } from '../app/services/grocerylistsService.service';
import { Product } from './components/models/product';
import { NgForm } from '@angular/forms/src/directives/ng_form';
import { ProductComponent } from './components/product/product.component';
import { GroceryList } from './components/models/grocerylist.model';
import { Router } from '@angular/router';
import { GroceryListProduct } from './components/models/grocerylistproduct.model';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  products: Product[];
  searchString: string;
  grocerylist: GroceryList;
  grocerylists:GroceryList[];
  dataService:DataService;
  grocerylistsService:GroceryListService; 
  grocerylistproduct: GroceryListProduct;

  isActiveLink(link:string) {
    return this.router.isActive(link, true)
  }  

  constructor(private router:Router) {}
  
  ngOnInit() {}


}
