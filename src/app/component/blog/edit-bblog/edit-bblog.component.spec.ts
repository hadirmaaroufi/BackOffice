import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditBblogComponent } from './edit-bblog.component';

describe('EditBblogComponent', () => {
  let component: EditBblogComponent;
  let fixture: ComponentFixture<EditBblogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditBblogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditBblogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
