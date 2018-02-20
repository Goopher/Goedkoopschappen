import { GroceryList } from "./grocerylist.model";
import { Product } from "./product";


export class GroceryListProduct {
  groceryListProductId: number;
  product: Product;
  grocerylist: GroceryList;
  amount: number;
}

