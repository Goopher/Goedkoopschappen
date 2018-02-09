import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';
import { Product } from '../components/models/product';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class DataService {
  const headers
  constructor(private http:HttpClient) {
    console.log('Data service connected...');
    this.headers = new HttpHeaders();
    this.headers.append('Content-type', 'application/json');
   }

<<<<<<< Updated upstream
   getProducts(searchString){
      return this.http.get('http://localhost:8080/products', {params: {"productName": searchString} })
      .map(res => res.json());
=======
   getProducts(searchString): Observable<Product[]>{
      return this.http.get<Product[]>('http://localhost:8080/products', {params: {"productName": searchString} });
>>>>>>> Stashed changes
   }

   addProductToCart(product) {
     console.log(product);
<<<<<<< Updated upstream
     const headers = new Headers();
     headers.append('Content-type', 'application/json');
     const options = new RequestOptions({headers: headers});
     return this.http.post("http://localhost:8080/addToCart", JSON.stringify(product), options)
=======
     return this.http.post("http://localhost:8080/addToCart", JSON.stringify(product), this.headers)
>>>>>>> Stashed changes
     .pipe();
   }
}
