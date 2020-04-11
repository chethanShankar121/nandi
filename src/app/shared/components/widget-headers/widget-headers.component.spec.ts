import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WidgetHeadersComponent } from './widget-headers.component';

describe('WidgetHeadersComponent', () => {
  let component: WidgetHeadersComponent;
  let fixture: ComponentFixture<WidgetHeadersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WidgetHeadersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WidgetHeadersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
