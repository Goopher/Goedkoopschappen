
import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { GroceryList } from '../../models/grocerylist.model';
import { DataService } from '../../../services/data.service';
import { GroceryListProduct } from '../../models/grocerylistproduct.model';
import { Product } from '../../models/product';
import { DecimalPipe, DatePipe } from '@angular/common';
import { GroceryListService } from '../../../services/grocerylistsService.service';


@Component({
  selector: 'app-grocerylistproduct',
  templateUrl: './grocerylistproduct.component.html',
  styleUrls: ['./grocerylistproduct.component.scss']
})
export class GrocerylistproductComponent implements OnInit, OnChanges {


  @Input() groceryListProduct:GroceryListProduct;
  grocerylistproducts:GroceryListProduct[];
  grocerylist: GroceryList;
  grocerylists: GroceryList[];
  activeGroceryList: GroceryList;
  initialGrocerylists: GroceryList[];


  constructor(private dataService:DataService, private grocerylistsService: GroceryListService) {
    
    
   }

  ngOnInit() {
    this.dataService.getGroceryLists().subscribe((grocerylists) => {
      this.grocerylists = grocerylists;
      console.log("Array: "  + this.grocerylists);
    });
  }

  ngOnChanges(){
    console.log("Change detected in GLP")
    if(this.groceryListProduct!=null){
      console.log(this.groceryListProduct)
      this.getGroceryListProducts();
      console.log(this.grocerylists);
      this.dataService.getGroceryList(this.activeGroceryList).subscribe(data => 
        {
          this.activeGroceryList = data;
          console.log(this.activeGroceryList);
        }
      );
    }  
  }

  getGroceryListProducts(){
    console.log("Retrieving grocerylistproduct...")
    this.dataService.getGroceryListProducts(this.activeGroceryList.groceryListId).subscribe((grocerylistproducts) => {
      this.grocerylistproducts = grocerylistproducts;
    });
  
  }

  setActiveGroceryList(grocerylist: GroceryList){
    this.activeGroceryList = grocerylist;
    console.log(this.activeGroceryList.totalPrice);
    this.grocerylistsService.setActiveGroceryList(grocerylist);
    this.getGroceryListProducts();
    console.log("Grocery list activated in glp component: " + grocerylist.groceryListName);
  }

  deleteProductFromList(groceryListProduct:GroceryListProduct) {
    this.dataService.deleteProductFromList(groceryListProduct).subscribe(data=>
      
      {
        this.activeGroceryList = data;
        
        this.getGroceryListProducts(); 
      }
        , error=> console.log(error));
    
  }

}
