import { Component, OnInit, Input, Output } from '@angular/core';


import { DataService } from '../../services/data.service';
import { Product } from '../models/product';
import { GroceryList } from '../models/grocerylist.model';
import { NgForm } from '@angular/forms';

import { GroceryListProduct } from '../models/grocerylistproduct.model';
import { GroceryListService } from '../../services/grocerylistsService.service';

@Component({
  selector: 'app-grocerylist',
  templateUrl: './grocerylist.component.html',
  styleUrls: ['./grocerylist.component.scss']
})
export class GrocerylistComponent implements OnInit {


  grocerylist: GroceryList;
  groceryListArray: GroceryList[];



  constructor(private dataService: DataService, private groceryListService: GroceryListService) {
    this.getAllGroceryLists();
  }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    let newList = new GroceryList();
    if (form.value.groceryList != null && form.value.groceryList != '') {
      newList.groceryListName = form.value.groceryList;
      console.log(newList);
      this.dataService.createGroceryList(newList).subscribe(
        (data => this.groceryListArray.push(data)),
        error => console.log(error));
      form.reset();
    }
    this.groceryListService.setGroceryLists(this.groceryListArray);
  }

  deleteGroceryList(grocerylist: GroceryList) {
    if (confirm("Weet u zeker dat u de lijst met naam " + grocerylist.groceryListName + " wilt verwijderen?")) {
      this.dataService.deleteGroceryList(grocerylist).subscribe();
      let index = this.groceryListArray.indexOf(grocerylist);
      if (index > -1) {
        this.groceryListArray.splice(index, 1);
      }
      this.groceryListService.setGroceryLists(this.groceryListArray);
    }
  }

  setGroceryList(grocerylist: GroceryList) {
    this.grocerylist = grocerylist;
    console.log("Set Grocery List: " + this.grocerylist);
  }

  getAllGroceryLists() {
    console.log("Getting grocerylists...")
    this.dataService.getGroceryLists().subscribe((grocerylists) => {
      this.groceryListArray = grocerylists;
      console.log("Array: " + this.groceryListArray);
    });
  }


}
