import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCartsComponent } from './edit-carts.component';

describe('EditCartsComponent', () => {
  let component: EditCartsComponent;
  let fixture: ComponentFixture<EditCartsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditCartsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditCartsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
