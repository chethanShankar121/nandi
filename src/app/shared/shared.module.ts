import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DropDownComponent } from './components/drop-down/drop-down.component';
import { WidgetHeadersComponent } from './components/widget-headers/widget-headers.component';
import { ErrorMessageComponent } from './components/error-message/error-message.component';
import { WidgetLoaderComponent } from './components/widget-loader/widget-loader.component';



@NgModule({
  declarations: [
    DropDownComponent,
    WidgetHeadersComponent,
    ErrorMessageComponent,
    WidgetLoaderComponent],
  imports: [
    CommonModule,
  ],
  exports: [
    DropDownComponent,
    WidgetHeadersComponent,
    ErrorMessageComponent,
    WidgetLoaderComponent
  ]
})
export class SharedModule { }
