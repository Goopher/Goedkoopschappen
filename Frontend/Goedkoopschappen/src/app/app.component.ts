import { Component, OnInit } from '@angular/core';
import { DataService } from '../app/services/data.service'
import { Product } from '../app/components/product/product.model'



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


