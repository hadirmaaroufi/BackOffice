import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditDelivererComponent } from './edit-deliverer.component';

describe('EditDelivererComponent', () => {
  let component: EditDelivererComponent;
  let fixture: ComponentFixture<EditDelivererComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditDelivererComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditDelivererComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
