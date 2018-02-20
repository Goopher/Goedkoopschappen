import { Component, OnInit, Input, Output } from '@angular/core';


import { DataService } from '../../services/data.service';
import { Product } from '../models/product';
import { GroceryList } from '../models/grocerylist.model';
import { NgForm } from '@angular/forms';

import { GroceryListProduct } from '../models/grocerylistproduct.model';

@Component({
  selector: 'app-grocerylist',
  templateUrl: './grocerylist.component.html',
  styleUrls: ['./grocerylist.component.scss']
})
export class GrocerylistComponent implements OnInit {


  grocerylist:GroceryList;
  groceryListArray:GroceryList[];


  
  constructor(private dataService:DataService) {
    this.getAllGroceryLists();   
   }

  ngOnInit() {
  }

  onSubmit(form:NgForm){
    let newList = new GroceryList();
    newList.groceryListName = form.value.groceryList;  
    console.log(newList);
    this.dataService.createGroceryList(newList).subscribe((data => this.groceryListArray.push(data)), error => console.log(error));
  }

  deleteGroceryList(grocerylist:GroceryList){
    this.dataService.deleteGroceryList(grocerylist).subscribe();
    let index = this.groceryListArray.indexOf(grocerylist);
    if(index > -1){
    this.groceryListArray.splice(index, 1);
    }

  setGroceryList(grocerylist:GroceryList){
    this.grocerylist = grocerylist;
    console.log(this.grocerylist);
  }


  }

  getAllGroceryLists(){    
    console.log("Getting grocerylists...")
    this.dataService.getGroceryLists().subscribe((grocerylists) => {
      this.groceryListArray = grocerylists;
      console.log(this.groceryListArray);
    });
  
    }
  

}
