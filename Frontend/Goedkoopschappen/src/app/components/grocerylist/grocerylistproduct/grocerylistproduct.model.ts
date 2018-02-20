
import { GroceryList } from "../grocerylist.model";
import { Product } from "../../models/product";

export class GroceryListProduct {
    product:Product;
    grocerylist:GroceryList;
    amount:number;
  }