import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LisOffreComponent } from './lis-offre.component';

describe('LisOffreComponent', () => {
  let component: LisOffreComponent;
  let fixture: ComponentFixture<LisOffreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LisOffreComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LisOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
