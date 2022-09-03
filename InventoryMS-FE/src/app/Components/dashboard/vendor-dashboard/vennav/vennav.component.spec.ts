import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VennavComponent } from './vennav.component';

describe('VennavComponent', () => {
  let component: VennavComponent;
  let fixture: ComponentFixture<VennavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VennavComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VennavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
