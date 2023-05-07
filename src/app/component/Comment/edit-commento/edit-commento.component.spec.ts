import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCommentoComponent } from './edit-commento.component';

describe('EditCommentoComponent', () => {
  let component: EditCommentoComponent;
  let fixture: ComponentFixture<EditCommentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditCommentoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditCommentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
