import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { GroceryList } from '../components/models/grocerylist.model';
import { Observable } from 'rxjs/Observable';
import { DataService } from './data.service';

@Injectable()
export class GroceryListService {


  private grocerylists : GroceryList[];
  private activeGroceryList : GroceryList;

  constructor() {
    
  }

  getGroceryLists() : GroceryList[] {
    console.log("Service getting grocerylists")
    return this.grocerylists.slice();
  }

  setGroceryLists(grocerylists:GroceryList[]){
    console.log("Service setting grocerylists")
    this.grocerylists = grocerylists;
  }

  setActiveGroceryList(grocerylist : GroceryList){
    this.activeGroceryList = grocerylist;
    console.log("GroceryList activated in glService: " + this.activeGroceryList.groceryListName)
  }

  getActiveGroceryList() : GroceryList {
    console.log("Getting active grocery list in gl Service: " + this.activeGroceryList.groceryListName)
    return this.activeGroceryList;
  }

}