import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LisSupplierComponent } from './lis-supplier.component';

describe('LisSupplierComponent', () => {
  let component: LisSupplierComponent;
  let fixture: ComponentFixture<LisSupplierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LisSupplierComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LisSupplierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
