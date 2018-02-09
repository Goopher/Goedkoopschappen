import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class DataService {

  constructor(private http:Http) {
    console.log('Data service connected...');

   }

   getProducts(searchString){
      return this.http.get('http://81.206.45.176:50000/products', {params: {"productName": searchString} })
      .map(res => res.json());
   }

   addProductToCart(product) {
     console.log(product);
     const headers = new Headers();
     headers.append('Content-type', 'application/json');
     const options = new RequestOptions({headers: headers});
     return this.http.post("http://81.206.45.176:50000/addToCart", JSON.stringify(product), options)
     .pipe();
   }
}
