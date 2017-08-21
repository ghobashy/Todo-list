import { TestBed, inject } from '@angular/core/testing';

import { LoginAndRegistrationService } from './login-and-registration.service';

describe('LoginAndRegistrationService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LoginAndRegistrationService]
    });
  });

  it('should be created', inject([LoginAndRegistrationService], (service: LoginAndRegistrationService) => {
    expect(service).toBeTruthy();
  }));
});
