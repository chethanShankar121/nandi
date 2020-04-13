import { SharedModule } from './../shared/shared.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { MaterialModule } from '../material-module';
import { LoginComponent } from './login/login.component';
import { SignupVerificationComponent } from './signup-verification/signup-verification.component';
import { SignupComponent } from './signup/signup.component';

@NgModule({
  declarations: [
    SignupComponent,
    LoginComponent,
    SignupVerificationComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,
  ]
})
export class LandingPageModule { }
