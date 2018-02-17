import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http'
import 'rxjs/add/operator/map';
import { Product } from '../components/product/product.model';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class DataService {
  headers;
  constructor(private http:HttpClient) {
    console.log('Data service connected...');
    this.headers = new HttpHeaders();
    this.headers.append('Content-type', 'application/json');
   }

   getProducts(searchString): Observable<Product[]>{
      return this.http.get<Product[]>('http://localhost:8080/products', {params: {"productName": searchString} });
   }

   addProductToCart(product) {
     console.log(product);
     return this.http.post("http://localhost:8080/addToCart", JSON.stringify(product))
     .pipe();
   }
}