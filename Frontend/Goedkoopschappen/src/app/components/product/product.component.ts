import { Component, OnInit, Input } from '@angular/core';
import { DataService } from '../../services/data.service'
import { Product } from './product.model'
import { DecimalPipe } from '@angular/common';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {


  @Input() products:Product[]
  data:Product[]
  product:Product;

  searchString: String;
  
  constructor(private dataService:DataService) { }

  ngOnInit() {

  }

  searchProducts(event, searchString) {
    if (event.key == "Enter") {
      this.dataService.getProducts(searchString).subscribe((products) => {
        this.products = products;
        this.searchString=searchString;
        this.data = this.products.slice(0,15);
        console.log(this.data.length)
      });
    }
  }

  addProductToCard(product:Product) {
    this.dataService.addProductToCart(product).subscribe();
    console.log(product.product_name);
  }

  loadMoreProducts() {
    this.data = this.products.slice(0,this.data.length + 5);
  }


}
