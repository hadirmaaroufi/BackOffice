import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LisPurchaseOrderComponent } from './lis-purchase-order.component';

describe('LisPurchaseOrderComponent', () => {
  let component: LisPurchaseOrderComponent;
  let fixture: ComponentFixture<LisPurchaseOrderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LisPurchaseOrderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LisPurchaseOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
