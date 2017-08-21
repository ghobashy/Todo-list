import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginAndRegistrationRoutingModule } from './login-and-registration-routing.module';
import { LoginComponent } from './login/login.component';
import { SharedModule } from "app/shared/shared.module";
import { LoginAndRegistrationComponent } from './login-and-registration.component';
import { LoginAndRegistrationService } from "app/login-and-registration/login-and-registration.service";

@NgModule({
  imports: [
    SharedModule,
    LoginAndRegistrationRoutingModule
  ],
  declarations: [LoginComponent, LoginAndRegistrationComponent],
  providers:[
    LoginAndRegistrationService
  ]
})
export class LoginAndRegistrationModule { }
