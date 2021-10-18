import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfterCancelComponent } from './after-cancel.component';

describe('AfterCancelComponent', () => {
  let component: AfterCancelComponent;
  let fixture: ComponentFixture<AfterCancelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfterCancelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfterCancelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
