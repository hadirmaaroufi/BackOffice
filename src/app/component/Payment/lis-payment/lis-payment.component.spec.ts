import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LisPaymentComponent } from './lis-payment.component';

describe('LisPaymentComponent', () => {
  let component: LisPaymentComponent;
  let fixture: ComponentFixture<LisPaymentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LisPaymentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LisPaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
