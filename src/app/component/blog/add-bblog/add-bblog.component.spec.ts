import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBblogComponent } from './add-bblog.component';

describe('AddBblogComponent', () => {
  let component: AddBblogComponent;
  let fixture: ComponentFixture<AddBblogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddBblogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddBblogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
