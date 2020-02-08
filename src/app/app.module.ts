import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './landing-page/home-page/home-page.component';
import { LandingPageHeaderComponent } from './landing-page/landing-page-header/landing-page-header.component';
import { MaterialModule } from './material-module';
import {MatExpansionModule} from '@angular/material/expansion';
import { HeaderComponent } from './common/header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { AdminModule } from './admin/admin.module';
@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    LandingPageHeaderComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    MatExpansionModule,
    BrowserAnimationsModule,
    FormsModule,
    AdminModule

  ],
  exports: [
    MatExpansionModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
