import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPromoCodeComponent } from './edit-promo-code.component';

describe('EditPromoCodeComponent', () => {
  let component: EditPromoCodeComponent;
  let fixture: ComponentFixture<EditPromoCodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditPromoCodeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditPromoCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
