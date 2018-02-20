import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { GroceryList } from '../../models/grocerylist.model';
import { DataService } from '../../../services/data.service';
import { GroceryListProduct } from '../../models/grocerylistproduct.model';
import { Product } from '../../models/product';
import { DecimalPipe } from '@angular/common';

@Component({
  selector: 'app-grocerylistproduct',
  templateUrl: './grocerylistproduct.component.html',
  styleUrls: ['./grocerylistproduct.component.scss']
})
export class GrocerylistproductComponent implements OnInit, OnChanges {


  @Input() grocerylist:GroceryList;
  grocerylistproducts:GroceryListProduct[];

  constructor(private dataService:DataService) {
    
   }

  ngOnInit() {
  }

  ngOnChanges(){
    console.log("Change detected in GLP")
    if(this.grocerylist!=null){
    console.log(this.grocerylist)
    this.getGroceryListProducts(this.grocerylist);
    console.log(this.grocerylistproducts)
    }
  }

  getGroceryListProducts(grocerylist){

    console.log("GLP being gotten")
    this.dataService.getGroceryListProducts(grocerylist.groceryListId).subscribe((grocerylistproducts) => {
      this.grocerylistproducts = grocerylistproducts;
    });
  
  }

}
