import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserManagementRoutingModule } from './user-management-routing.module';
import { EditUserComponent } from './edit-user/edit-user.component';
import { UserManagementComponent } from './user-management.component';

@NgModule({
  imports: [
    CommonModule,
    UserManagementRoutingModule
  ],
  declarations: [EditUserComponent, UserManagementComponent]
})
export class UserManagementModule { }
