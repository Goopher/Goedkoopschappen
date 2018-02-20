import { Component, OnInit, Input } from '@angular/core';

import { DataService } from '../../../services/data.service';

import { Product } from '../../models/product';
import { GroceryList } from '../../models/grocerylist.model';
import { GroceryListProduct } from '../../models/grocerylistproduct.model';

@Component({
  selector: 'app-grocerylistproduct',
  templateUrl: './grocerylistproduct.component.html',
  styleUrls: ['./grocerylistproduct.component.scss']
})
export class GrocerylistproductComponent implements OnInit {


  @Input()
  products:Product[];
  product:Product;
  grocerylist:GroceryList;
  grocerylistproduct:GroceryListProduct;
  grocerylistproducts:GroceryListProduct[];
  show: boolean = false;

  constructor(private dataService:DataService) { }

  ngOnInit() {
  }

  getGroceryListProducts(listId){

    console.log()
    this.dataService.getGroceryListProducts(listId).subscribe((grocerylistproducts) => {
      this.grocerylistproducts = grocerylistproducts;
    });
  
  }

}
