import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HireBusComponent } from './hire-bus.component';

describe('HireBusComponent', () => {
  let component: HireBusComponent;
  let fixture: ComponentFixture<HireBusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HireBusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HireBusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
