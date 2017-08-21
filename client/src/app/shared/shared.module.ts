import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AlertComponent } from './widgets/components/alert/alert.component';
import { StorageService } from "app/shared/services/storage.service";
import { AuthenticationService } from "app/shared/services/authentication.service";
import { AlertService } from "app/shared/services/alert.service";
import { AuthenticationGuard } from "app/shared/guards/authentication.guard";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule, RequestOptions } from "@angular/http";
import { DefaultRequestOptions } from "app/shared/services/default-request-options.service";

@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    ReactiveFormsModule,
  ],
  declarations: [
    AlertComponent],
  exports:[FormsModule,
    CommonModule,
    ReactiveFormsModule,
    AlertComponent],
  providers:[StorageService,AuthenticationService, AlertService, AuthenticationGuard, 
    {provide: RequestOptions, useClass: DefaultRequestOptions }]
})
export class SharedModule { }
