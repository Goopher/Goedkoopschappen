import { Component, OnInit, Input } from '@angular/core';
import { DataService } from '../../services/data.service'

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {


  @Input() products:Product[]
  data:Product[]

  constructor(private dataService:DataService) { }

  ngOnInit() {

  }

  searchProducts(searchString) {
    this.dataService.getProducts(searchString).subscribe((products) => {
      this.products = products;
      this.data = this.products.slice(0,5);
      console.log(products)
    }); 
  }

  loadMoreProducts() {
    this.data = this.products.slice(0,this.data.length + 5);
  }


}

interface Product {
  product_name:string;
  product_brand:string;
  description:string;
  house_brand:boolean;
  price:number;
  product_url:string;
  image_url:string;
}
