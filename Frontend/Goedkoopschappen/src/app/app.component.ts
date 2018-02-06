import { Component, OnInit } from '@angular/core';
import { DataService } from '../app/services/data.service'



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'app';
  products: Product[];
  searchString: string;



  constructor() {  }
  ngOnInit(){}

}


interface Product {
  product_name: string;
  product_brand: string;
  description: string;
  house_brand: boolean;
  price: number;
  product_url: string;
  image_url: string;
}