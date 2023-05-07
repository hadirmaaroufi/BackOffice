import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCammanLineComponent } from './list-camman-line.component';

describe('ListCammanLineComponent', () => {
  let component: ListCammanLineComponent;
  let fixture: ComponentFixture<ListCammanLineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListCammanLineComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListCammanLineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
