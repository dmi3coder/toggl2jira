import { TestBed, inject } from '@angular/core/testing';

import { TogglService } from './toggl.service';

describe('TogglService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TogglService]
    });
  });

  it('should be created', inject([TogglService], (service: TogglService) => {
    expect(service).toBeTruthy();
  }));
});
