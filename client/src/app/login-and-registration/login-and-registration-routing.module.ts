import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from "app/login-and-registration/login/login.component";
import { LoginAndRegistrationModule } from "app/login-and-registration/login-and-registration.module";

const routes: Routes = [
  {
    path: '', component:LoginAndRegistrationModule,
    children: [
      {
        path: 'login',
        component: LoginComponent
      }
    ]
  }
  // {
  //   path:'register',
  //   component: RegistrationComponent
  // }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginAndRegistrationRoutingModule { }
