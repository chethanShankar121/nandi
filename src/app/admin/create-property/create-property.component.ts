import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-property',
  templateUrl: './create-property.component.html',
  styleUrls: ['./create-property.component.css']
})
export class CreatePropertyComponent implements OnInit {

  propertyForSelected;
  selectedPropertyType;
  selectedSubPropertyType;
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
  propertyTypeOptions = [
    {
      name: 'Residential',
      key: 'residential'
    },
    {
      name: 'Commericial',
      key: 'commercial'
    },
    {
      name: 'Others',
      key: 'others'
    }
  ];
  propertySubType = {
    'residential': [
      {
        'name': 'Flat',
        'key': 'flat'
      },
      {
        'name': 'Apartment',
        'key': 'apartment'
      },
      {
        'name': 'House/Villa',
        'key': 'villa'
      },
      {
        'name': 'Plot/Land',
        'key': 'plot'
      },
    ],
    'commercial': [
      {
        'name': 'Office Space',
        'key': 'officeSpace'
      },
      {
        'name': 'Shop/Showroom',
        'key': 'shop'
      },
      {
        'name': 'Commercial Land',
        'key': 'commercialLand'
      },
    ],
    'others': [
      {
        'name': 'Agricultural Land',
        'key': 'agriculturalLand'
      },
      {
        'name': 'Farm House',
        'key': 'farmHouse'
      },
      {
        'name': 'Layouts',
        'key': 'layouts'
      },
    ]
  };
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
  propertyTypeSelected(event) {
    if (event) {
      this.selectedPropertyType = event.key;
    }
  }
  propertySubTypeSelected(event) {
    if (event) {
      this.selectedSubPropertyType = event.key;
    }
  }
}
