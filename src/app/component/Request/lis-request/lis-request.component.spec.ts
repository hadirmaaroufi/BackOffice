import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LisRequestComponent } from './lis-request.component';

describe('LisRequestComponent', () => {
  let component: LisRequestComponent;
  let fixture: ComponentFixture<LisRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LisRequestComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LisRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
