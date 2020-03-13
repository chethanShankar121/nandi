import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-property-type-select',
  templateUrl: './property-type-select.component.html',
  styleUrls: ['./property-type-select.component.css']
})
export class PropertyTypeSelectComponent implements OnInit {

  typeList = [
    {
      value: 'residential',
      name: 'Residential'
    },
    {
      value: 'commercial',
      name: 'Commercial'
    },
    {
      value: 'others',
      name: 'Others'
    }
  ];
  selectedValue: string;
  constructor() { }

  ngOnInit() {
  }

  typeSelection(a) {
    
  }

}
