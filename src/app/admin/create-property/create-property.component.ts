import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-property',
  templateUrl: './create-property.component.html',
  styleUrls: ['./create-property.component.css']
})
export class CreatePropertyComponent implements OnInit {

  propertyForSelected;
  scrollMenuItems = [
    {
      name: 'Property Details',
      id: 'property-details'
    },
    {
      name: 'Location',
      id: 'property-location'
    },
    {
      name: 'Features',
      id: 'property-features'
    },
    {
      name: 'Property Description',
      id: 'property-description'
    },
    {
      name: 'Upload Photos',
      id: 'property-photos'
    },
  ];
  purposeOptions = [
    {
      name: 'Sell',
      key: 'sell'
    },
    {
      name: 'Rent',
      key: 'rent',
    },
    {
      name: 'Lease',
      key: 'lease',
    }
  ];

  constructor() { }

  ngOnInit() { }
  scrollToView(menu, e) {
    console.log(menu);
    console.log(e.target);
    let el = document.getElementById(menu);
    console.log(el);
    el.scrollIntoView({ behavior: 'smooth' });
  }
  typeSelection(type) {
    console.log(type);
  }
}
