import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PropertyTypeSelectComponent } from '../secondary-components/property-type-select/property-type-select.component';
import { CreatePropertyComponent } from './create-property/create-property.component';
import { AdminLandingPageComponent } from './admin-landing-page/admin-landing-page.component';
import {MatExpansionModule} from '@angular/material/expansion';
import { MaterialModule } from '../material-module';



@NgModule({ 
  declarations: [PropertyTypeSelectComponent,
    CreatePropertyComponent,
    AdminLandingPageComponent,
  ],
  imports: [
    CommonModule,
    MatExpansionModule,
    MaterialModule
  ]
})
export class AdminModule { }
