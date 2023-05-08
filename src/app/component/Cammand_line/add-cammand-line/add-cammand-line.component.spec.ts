import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCammandLineComponent } from './add-cammand-line.component';

describe('AddCammandLineComponent', () => {
  let component: AddCammandLineComponent;
  let fixture: ComponentFixture<AddCammandLineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCammandLineComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddCammandLineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
