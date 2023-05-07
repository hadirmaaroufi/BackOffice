import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LisTvaComponent } from './lis-tva.component';

describe('LisTvaComponent', () => {
  let component: LisTvaComponent;
  let fixture: ComponentFixture<LisTvaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LisTvaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LisTvaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
