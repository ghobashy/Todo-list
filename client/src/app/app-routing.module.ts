import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AuthenticationGuard } from "app/shared/guards/authentication.guard";
import { PagesComponent } from "app/pages/pages.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: "pages/todo/list",
    pathMatch: 'full'
  },
  {
    path:'auth',
    loadChildren:'app/login-and-registration/login-and-registration.module#LoginAndRegistrationModule'
  },
  {
    path:'pages',
    component: PagesComponent,
    canActivate:[AuthenticationGuard],
    children:[
      {
        // Home
        path: "todo",
        loadChildren: 'app/list-management/list-management.module#ListManagementModule'
      },
      {
        // Registration
        path: "user",
        loadChildren: 'app/user-management/user-management.module#UserManagementModule',
      }
    ]
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})

export class AppRoutingModule { }
