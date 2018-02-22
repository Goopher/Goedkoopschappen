
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
  total:number;


  constructor(private dataService:DataService, private grocerylistsService: GroceryListService) {
    
    
   }

  ngOnInit() {
    console.log("GLP AM INITIATED!")
    this.dataService.getGroceryLists().subscribe((grocerylists) => {
      this.grocerylists = grocerylists;
      console.log("Array: "  + this.grocerylists);
    });
    this.grocerylistsService.setGroceryLists(this.grocerylists);
  }

  ngOnChanges(){
    console.log("Change detected in GLP")
    if(this.groceryListProduct!=null){
      console.log(this.groceryListProduct)
      this.setGroceryListProducts();
       console.log("GLP IS CHANGED!")
    
    
       this.dataService.getGroceryLists().subscribe((grocerylists) => {
      this.grocerylists = grocerylists;
      console.log("CHECK CHECK CHECK");
    });
    this.setActiveGroceryList(this.activeGroceryList);
    this.setGroceryListProducts();
      this.total = this.activeGroceryList.totalPrice;
      
      }

     
    
    // this.dataService.getGroceryListProducts(this.activeGroceryList).subscribe((grocerylistproducts) => {
    //   this.grocerylistproducts = grocerylistproducts;
    //   console.log("DOES IT WORK?");});
   

    
  }

  setGroceryListProducts(){
    console.log("Retrieving grocerylistproduct...")
    this.dataService.getGroceryListProducts(this.activeGroceryList.groceryListId).subscribe((grocerylistproducts) => {
      this.grocerylistproducts = grocerylistproducts;
    });
    this.total = this.activeGroceryList.totalPrice;
  
  }

  setActiveGroceryList(grocerylist: GroceryList){
    this.activeGroceryList = grocerylist;
    this.grocerylistsService.setActiveGroceryList(this.activeGroceryList);
    this.setGroceryListProducts();
    console.log("Grocery list activated in glp component: " + this.activeGroceryList.groceryListName);

  }

}
