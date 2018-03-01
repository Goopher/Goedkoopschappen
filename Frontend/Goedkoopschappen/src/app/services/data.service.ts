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
  SERVER_IP = 'http://81.206.45.176:55000';

  getProducts(searchString): Observable<Product[]> {
    let headers = new HttpHeaders();
    headers = headers.append('Content-type', 'application/json');
    return this.http.get<Product[]>(this.SERVER_IP + '/api/products', { params: { "productName": searchString } });
  }

   getGroceryLists(): Observable<GroceryList[]>{
      return this.http.get<GroceryList[]>(this.SERVER_IP + "/api/groceryLists");
   }
   
   getGroceryList(list : GroceryList): Observable<GroceryList>{
    return this.http.get<GroceryList>(this.SERVER_IP + "/api/groceryListById?listId=" + list.groceryListId);
 }

   getGroceryListProducts(listId): Observable<GroceryListProduct[]>{
     return this.http.get<GroceryListProduct[]>(this.SERVER_IP + "/api/groceryList", {params: {"listId": listId} })
   }

  createGroceryList(list:GroceryList): Observable<GroceryList> {
    const body = list;
    console.log('body = ' + body)
    let headers = new HttpHeaders();
    headers = headers.append('Content-Type', 'application/json');
    return this.http.post<GroceryList>(this.SERVER_IP + "/api/createGroceryList", body);
  }

  deleteProductFromList(product:GroceryListProduct): Observable<GroceryList>{
    let headers = new HttpHeaders();
    headers = headers.append('Content-type', 'application/json');
    console.log(product);
    
    return this.http.delete<GroceryList>(this.SERVER_IP + "/api/deleteGroceryListProduct?id=" + product.groceryListProductId)
  }

  deleteGroceryList(list:GroceryList) {
    let headers = new HttpHeaders();
    headers = headers.append('Content-type', 'application/json');
    return this.http.delete(this.SERVER_IP + "/api/deleteGroceryList?listId=" + list.groceryListId);
  }

  addProductToCart(product): Observable<GroceryListProduct> {
    const body = product;
    let headers = new HttpHeaders();
    this.activeGroceryList = this.grocerylistsService.getActiveGroceryList();    
    headers = headers.append('Content-type', 'application/json');
    return this.http.post<GroceryListProduct>(this.SERVER_IP + "/api/addToCart?groceryListId="+this.activeGroceryList.groceryListId, body)
  }

}
