import { Component } from '@angular/core';
import { HomePageComponent } from '../../landing-page/home-page/home-page.component';
import { AdminLandingPageComponent } from '../../admin/admin-landing-page/admin-landing-page.component';
import { CreatePropertyComponent } from '../../admin/create-property/create-property.component';
export const AllRoutes = [
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    },
    {
        path: 'home',
        component: HomePageComponent
    },
    {
        path: 'admin',
        component: AdminLandingPageComponent,
        pathMatch: 'prefix',
        // children: [
        //     {
        //         path: '',
        //         redirectTo: '/admin',
        //         pathMatch: 'full'
        //     },
        //     {
        //         path: 'create-property',
        //         component: CreatePropertyComponent
        //     }
        // ]
    },
    {
        path: 'admin/create-property',
        component: CreatePropertyComponent,
        pathMatch: 'full'
    },
    { 
        path:"**", 
        redirectTo: '/home',
        pathMatch: 'full' 
    },
];
