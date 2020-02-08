import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, NavigationEnd } from '@angular/router';


@Component({
  selector: 'app-admin-landing-page',
  templateUrl: './admin-landing-page.component.html',
  styleUrls: ['./admin-landing-page.component.css']
})
export class AdminLandingPageComponent implements OnInit {

  menuItems = [
    {
      name : 'Add Property',
      link: 'create-property'
    },
    {
      name : 'Edit Property',
      link: 'editProperty'
    },
    {
      name : 'Add Property to Home Page',
      link: 'selectPropertyForHomeScreen'
    },
    {
      name : 'View Brokers',
      link: 'viewBrokers'
    }
];
  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute
    ) { }

  ngOnInit() {
  }

  navigateTo(link) {
    console.log(link);
    if (link === 'create-property') {
      this.router.navigate(['create-property'], {
        relativeTo: this.activatedRoute,
        queryParamsHandling: 'merge'
      });
    }

  }
}
