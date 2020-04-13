import { ExtraServices } from './services/extra.service';
import { CommonResponseService } from './services/commonResponse.service';
import { ErrorHandlingService } from './services/error-handling.service';
import { LandingPageModule } from './landing-page/landing-page.module';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatExpansionModule } from '@angular/material/expansion';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminModule } from './admin/admin.module';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContextualMenuComponent } from './common/contextual-menu/contextual-menu.component';
import { HeaderComponent } from './common/header/header.component';
import { HomePageComponent } from './landing-page/home-page/home-page.component';
import { LandingPageHeaderComponent } from './landing-page/landing-page-header/landing-page-header.component';
import { MaterialModule } from './material-module';
import { OverlayComponent } from './secondary-components/overlay/overlay.component';
// import { SharedModule } from './shared/shared.module';
@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    LandingPageHeaderComponent,
    HeaderComponent,
    ContextualMenuComponent,
    OverlayComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    MatExpansionModule,
    BrowserAnimationsModule,
    FormsModule,
    AdminModule,
    ReactiveFormsModule,
    HttpClientModule,
    LandingPageModule
  ],
  exports: [
    MatExpansionModule,
    MaterialModule,
  ],
  providers: [ErrorHandlingService, CommonResponseService, ExtraServices],
  bootstrap: [AppComponent]
})
export class AppModule { }
