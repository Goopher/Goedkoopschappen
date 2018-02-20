import { Component, OnInit, Input, Output } from '@angular/core';

import { GroceryList } from './grocerylist.model';
import { DataService } from '../../services/data.service';
import { Product } from '../models/product';

@Component({
  selector: 'app-grocerylist',
  templateUrl: './grocerylist.component.html',
  styleUrls: ['./grocerylist.component.scss']
})
export class GrocerylistComponent implements OnInit {

  @Input()
  products:Product[];
  product:Product;
  @Input() grocerylist:GroceryList;
  grocerylists:GroceryList[];
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

  toggle(){
    this.show = !this.show;
  }

  

}
