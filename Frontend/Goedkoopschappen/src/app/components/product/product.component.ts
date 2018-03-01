import { Component, OnInit, Input, Output } from '@angular/core';
import { DataService } from '../../services/data.service'
import { DecimalPipe } from '@angular/common';
import { Product } from '../models/product';
import { NgForm } from '@angular/forms/src/directives/ng_form';
import { EventEmitter } from 'events';
import { GroceryListProduct } from '../models/grocerylistproduct.model';
import { GroceryListService } from '../../services/grocerylistsService.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {


  products: Product[];
  product = new Product();
  groceryListProduct: GroceryListProduct;
  data = [];
  searched = false;
  searchString: String;
  @Output() updates = new EventEmitter();


  constructor(private dataService: DataService, private groceryListService: GroceryListService) { }

  ngOnInit() {
    this.data = [];
  }

  onSubmit(form: NgForm) {
    const searchString = form.value.product;
    console.log(searchString)
    this.searchProducts(searchString);
  }

  searchProducts(searchString) {
    this.dataService.getProducts(searchString).subscribe((products) => {
      this.products = products;
      this.searchString = searchString;
      this.data = this.products.slice(0, 15);
      this.searched = true;
      console.log(this.data.length)
    });
  }

  addProductToCart(product: Product) {
    console.log(product);
    this.dataService.addProductToCart(product).subscribe(data => this.groceryListProduct = data);
    let groceryList = this.groceryListService.getActiveGroceryList();
    groceryList.totalPrice - product.price;
    this.groceryListService.setActiveGroceryList(groceryList);
  }

  loadMoreProducts() {
    this.data = this.products.slice(0, this.data.length + 5);
  }


}
