import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: "todo/list",
    pathMatch: 'full'
  },
  {
    path:'pages',
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
