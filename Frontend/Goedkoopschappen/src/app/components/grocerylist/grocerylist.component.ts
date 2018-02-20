import { Component, OnInit, Input, Output } from '@angular/core';


import { DataService } from '../../services/data.service';
import { Product } from '../models/product';
import { GroceryList } from '../models/grocerylist.model';
import { GroceryListProduct } from '../models/grocerylistproduct.model';

@Component({
  selector: 'app-grocerylist',
  templateUrl: './grocerylist.component.html',
  styleUrls: ['./grocerylist.component.scss']
})
export class GrocerylistComponent implements OnInit {

  
  
  grocerylist:GroceryList;
  grocerylists:GroceryList[];
  grocerylistproducts:GroceryListProduct[];
  show: boolean = false;
  
  constructor(private dataService:DataService) {
    this.getAllGroceryLists();   
   }

  ngOnInit() {
  }

  getAllGroceryLists(){
    
    console.log()
    this.dataService.getGroceryLists().subscribe((grocerylists) => {
      this.grocerylists = grocerylists;
    });
  
  }

  setGroceryList(grocerylist:GroceryList){
    this.grocerylist = grocerylist;
    console.log(this.grocerylist);
  }

  toggle(){
    this.show = !this.show;
  }

  

}
