import { Component, OnInit } from '@angular/core';
import {MatExpansionModule} from '@angular/material/expansion';

@Component({
  selector: 'app-landing-page-header',
  templateUrl: './landing-page-header.component.html',
  styleUrls: ['./landing-page-header.component.css']
})
export class LandingPageHeaderComponent implements OnInit {

  constructor() { }
  panelOpenState = false;
  ngOnInit() {
  }

}
