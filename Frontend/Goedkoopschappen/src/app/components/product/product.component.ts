import { Component, OnInit } from '@angular/core';
import { DataService } from '../../services/data.service'

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products:Product[]



  constructor(private dataService:DataService) { }

  ngOnInit() {
    this.dataService.getProducts().subscribe((products) => {
      this.products = products;
      console.log(products)
    }); 
  }

}

interface Product{
  product_name:string;
  product_brand:string;
  description:string;
  house_brand:boolean;
  price:number;
  product_url:string;
  image_url:string;
}
