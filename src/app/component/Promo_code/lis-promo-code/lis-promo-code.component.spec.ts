import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LisPromoCodeComponent } from './lis-promo-code.component';

describe('LisPromoCodeComponent', () => {
  let component: LisPromoCodeComponent;
  let fixture: ComponentFixture<LisPromoCodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LisPromoCodeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LisPromoCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
