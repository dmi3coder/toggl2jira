import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TogglTaskComponent } from './toggl-task.component';

describe('TogglTaskComponent', () => {
  let component: TogglTaskComponent;
  let fixture: ComponentFixture<TogglTaskComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TogglTaskComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TogglTaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
