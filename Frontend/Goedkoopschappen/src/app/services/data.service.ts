import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';
import { Product } from '../components/models/product';
import { Observable } from 'rxjs/Observable';
import { GroceryList } from '../components/models/grocerylist.model';
import { GroceryListProduct } from '../components/models/grocerylistproduct.model';
import { GroceryListService } from './grocerylistsService.service';

@Injectable()
export class DataService {
  
  constructor(private http: HttpClient, private grocerylistsService:GroceryListService) {
    console.log('Data service connected...');

  }
  activeGroceryList : GroceryList;

  getProducts(searchString): Observable<Product[]> {
    let headers = new HttpHeaders();
    headers = headers.append('Content-type', 'application/json');
    console.log("GET PRODUCTS");
    return this.http.get<Product[]>('http://localhost:8080/api/products', { params: { "productName": searchString } });
  }

   getGroceryLists(): Observable<GroceryList[]>{
    console.log("GET GROCERY LISTS");
      return this.http.get<GroceryList[]>("http://localhost:8080/api/groceryLists");
   }

   getGroceryListProducts(listId): Observable<GroceryListProduct[]>{
    console.log("GET GROCERY LIST PRODUCTS");
     return this.http.get<GroceryListProduct[]>("http://localhost:8080/api/groceryList", {params: {"listId": listId} })
   }

  createGroceryList(list:GroceryList): Observable<GroceryList> {
    const body = list;
    console.log('body = ' + body)
    let headers = new HttpHeaders();
    headers = headers.append('Content-Type', 'application/json');
    console.log("CREATE GROCERY LIST");
    return this.http.post<GroceryList>("http://localhost:8080/api/createGroceryList", body);
  }

  deleteProductFromList(product:GroceryListProduct){
    let headers = new HttpHeaders();
    headers = headers.append('Content-type', 'application/json');
    console.log(product);
    console.log("DELETE PRODUCT FROM LIST");
    
    return this.http.delete("http://localhost:8080/api/deleteGroceryListProduct?id=" + product.groceryListProductId)
  }

  deleteGroceryList(list:GroceryList) {
    let headers = new HttpHeaders();
    headers = headers.append('Content-type', 'application/json');
    console.log("DELETE GROCERY LIST");
    return this.http.delete("http://localhost:8080/api/deleteGroceryList?listId=" + list.groceryListId);
  }

  addProductToCart(product): Observable<GroceryListProduct> {
    const body = product;
    let headers = new HttpHeaders();
    this.activeGroceryList = this.grocerylistsService.getActiveGroceryList();    
    headers = headers.append('Content-type', 'application/json');
    console.log("ADD PRODUCT TO LIST");
    
    return this.http.post<GroceryListProduct>("http://localhost:8080/api/addToCart?groceryListId="
    +this.activeGroceryList.groceryListId, body)
  }

}
