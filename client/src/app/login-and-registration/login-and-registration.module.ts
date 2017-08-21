import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginAndRegistrationRoutingModule } from './login-and-registration-routing.module';
import { LoginComponent } from './login/login.component';
import { SharedModule } from "app/shared/shared.module";
import { LoginAndRegistrationComponent } from './login-and-registration.component';

@NgModule({
  imports: [
    SharedModule,
    LoginAndRegistrationRoutingModule
  ],
  declarations: [LoginComponent, LoginAndRegistrationComponent]
})
export class LoginAndRegistrationModule { }
