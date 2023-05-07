import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LisUserComponent } from './lis-user.component';

describe('LisUserComponent', () => {
  let component: LisUserComponent;
  let fixture: ComponentFixture<LisUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LisUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LisUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
