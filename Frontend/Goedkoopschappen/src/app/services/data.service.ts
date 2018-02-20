import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';
import { Product } from '../components/models/product';
import { Observable } from 'rxjs/Observable';
import { GroceryList } from '../components/grocerylist/grocerylist.model';
import { GroceryListProduct } from '../components/grocerylist/grocerylistproduct/grocerylistproduct.model';

@Injectable()
export class DataService {
  constructor(private http: HttpClient) {
    console.log('Data service connected...');

  }

  getProducts(searchString): Observable<Product[]> {
    let headers = new HttpHeaders();
    headers = headers.append('Content-type', 'application/json');
    return this.http.get<Product[]>('http://localhost:8080/api/products', { params: { "productName": searchString } });
  }

   getGroceryLists(): Observable<GroceryList[]>{
      return this.http.get<GroceryList[]>("http://localhost:8080/api/groceryLists");
   }

   getGroceryListProducts(listId): Observable<GroceryListProduct[]>{
     return this.http.get<GroceryListProduct[]>("http://localhost:8080/api/groceryList", {params: {"listId": listId} })
   }

  addProductToCart(product) {
    const body = product;
    let headers = new HttpHeaders();
    headers = headers.append('Content-type', 'application/json');
    return this.http.post("http://localhost:8080/api/addToCart?groceryListId=1", body);
  }
}
