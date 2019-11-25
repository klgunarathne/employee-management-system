import { TestBed } from '@angular/core/testing';

import { AllocateService } from './allocate.service';

describe('AllocateService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AllocateService = TestBed.get(AllocateService);
    expect(service).toBeTruthy();
  });
});
