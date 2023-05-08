import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDelivererComponent } from './list-deliverer.component';

describe('ListDelivererComponent', () => {
  let component: ListDelivererComponent;
  let fixture: ComponentFixture<ListDelivererComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListDelivererComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListDelivererComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
