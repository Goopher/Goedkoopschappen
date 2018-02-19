import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { DataService } from '../app/services/data.service';
import { Product } from './components/models/product';
import { NgForm } from '@angular/forms/src/directives/ng_form';
import { ProductComponent } from './components/product/product.component';
=======
import { DataService } from '../app/services/data.service'
import { Product } from '../app/components/product/product.model'
>>>>>>> master



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'app';
  products: Product[];

  constructor() {}
  ngOnInit(){}

  

<<<<<<< HEAD
}
=======

>>>>>>> master
