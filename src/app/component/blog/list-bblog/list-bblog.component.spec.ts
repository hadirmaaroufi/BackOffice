import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListBblogComponent } from './list-bblog.component';

describe('ListBblogComponent', () => {
  let component: ListBblogComponent;
  let fixture: ComponentFixture<ListBblogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListBblogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListBblogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
