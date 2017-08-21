import { Injectable } from '@angular/core';
import { AuthenticationService } from "app/shared/services/authentication.service";

@Injectable()
export class LoginAndRegistrationService {

  constructor(private authService:AuthenticationService) { }


  public login(username:string, password:string){
    return this.authService.login(username,password);
  }

}
