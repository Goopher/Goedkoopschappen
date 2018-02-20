import { Component, OnInit } from '@angular/core';
import { DataService } from '../app/services/data.service'
import { GroceryList } from './components/grocerylist/grocerylist.model';
import { Product } from './components/models/product';



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




  constructor() {  }
  ngOnInit(){}

}


