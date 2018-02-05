import { Component, OnInit } from '@angular/core';
import { DataService } from '../app/services/data.service'

}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  products:Product[];
  searchString:string;

  

  constructor(private dataService:DataService){

  }

  ngOnInit(){

  }

  searchProducts(event) {
    if(event.key == "Enter"){
      console.log(event);
    
    this.dataService.getProducts(this.searchString).subscribe((products) => {
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