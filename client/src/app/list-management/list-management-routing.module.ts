import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListManagementComponent } from "app/list-management/list-management.component";
import { TodoListingComponent } from "app/list-management/todo-listing/todo-listing.component";

const routes: Routes = [
  {
    path:"",
    component:ListManagementComponent,
    children:[
      {
        path:'list',
        component:TodoListingComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ListManagementRoutingModule { }
