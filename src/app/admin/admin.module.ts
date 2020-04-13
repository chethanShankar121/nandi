import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PropertyTypeSelectComponent } from '../secondary-components/property-type-select/property-type-select.component';
import { CreatePropertyComponent } from './create-property/create-property.component';
import { AdminLandingPageComponent } from './admin-landing-page/admin-landing-page.component';
import { MatExpansionModule } from '@angular/material/expansion';
import { MaterialModule } from '../material-module';
import { SharedModule } from '../shared/shared.module';

const adminRoutes = [{
  path: '',
  component: AdminLandingPageComponent,
  pathMatch: 'full'
},
{
  path: 'create-property',
  component: CreatePropertyComponent,
  pathMatch: 'full'
}];

@NgModule({
  declarations: [PropertyTypeSelectComponent,
    CreatePropertyComponent,
    AdminLandingPageComponent,
  ],
  imports: [
    RouterModule.forChild(adminRoutes),
    CommonModule,
    MatExpansionModule,
    MaterialModule,
    SharedModule
  ]
})
export class AdminModule { }
