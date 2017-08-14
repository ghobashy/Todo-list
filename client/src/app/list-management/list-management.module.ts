import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ListManagementRoutingModule } from './list-management-routing.module';
import { TodoListingComponent } from './todo-listing/todo-listing.component';
import { NewTodoComponent } from './new-todo/new-todo.component';
import { EditTodoComponent } from './edit-todo/edit-todo.component';
import { ListManagementComponent } from './list-management.component';

@NgModule({
  imports: [
    CommonModule,
    ListManagementRoutingModule
  ],
  declarations: [TodoListingComponent, NewTodoComponent, EditTodoComponent, ListManagementComponent]
})
export class ListManagementModule { }
