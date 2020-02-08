import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AllRoutes } from './shared/constants/routes';


const routes: Routes = AllRoutes;

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
