import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCammandLineComponent } from './edit-cammand-line.component';

describe('EditCammandLineComponent', () => {
  let component: EditCammandLineComponent;
  let fixture: ComponentFixture<EditCammandLineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditCammandLineComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditCammandLineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
