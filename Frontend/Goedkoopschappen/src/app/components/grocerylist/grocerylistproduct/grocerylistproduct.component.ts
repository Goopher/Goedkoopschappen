
import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { GroceryList } from '../../models/grocerylist.model';
import { DataService } from '../../../services/data.service';
import { GroceryListProduct } from '../../models/grocerylistproduct.model';
import { Product } from '../../models/product';
import { DecimalPipe, DatePipe } from '@angular/common';


@Component({
  selector: 'app-grocerylistproduct',
  templateUrl: './grocerylistproduct.component.html',
  styleUrls: ['./grocerylistproduct.component.scss']
})
export class GrocerylistproductComponent implements OnInit, OnChanges {


  @Input() groceryListProduct:GroceryListProduct;
  grocerylistproducts:GroceryListProduct[];


  constructor(private dataService:DataService) {
    
   }

  ngOnInit() {
    this.getGroceryListProducts();
  }

  ngOnChanges(){
    console.log("Change detected in GLP")
    if(this.groceryListProduct!=null){
    console.log(this.groceryListProduct)
    this.getGroceryListProducts();
    }
  }

  getGroceryListProducts(){
    console.log("Retrieving grocerylistproduct...")
    this.dataService.getGroceryListProducts(1).subscribe((grocerylistproducts) => {
      this.grocerylistproducts = grocerylistproducts;
    });
  
  }

}
