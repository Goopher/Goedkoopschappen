import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrocerylistproductComponent } from './grocerylistproduct.component';

describe('GrocerylistproductComponent', () => {
  let component: GrocerylistproductComponent;
  let fixture: ComponentFixture<GrocerylistproductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrocerylistproductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrocerylistproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
