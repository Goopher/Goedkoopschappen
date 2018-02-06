import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class DataService {

  constructor(public http:Http) {
    console.log('Data service connected...');
   }

   getProducts(){
      return this.http.get('http://localhost:8080/products', {params: {"productName": "cola"}})
      .map(res => res.json());
   }

}