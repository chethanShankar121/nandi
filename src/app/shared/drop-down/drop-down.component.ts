import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-drop-down',
  templateUrl: './drop-down.component.html',
  styleUrls: ['./drop-down.component.css']
})
export class DropDownComponent implements OnInit {
  @Input() dropdownLabel;
  @Input() dropdownList;
  showDropDown = false;
  selectedItem = { name: null, key: null };
  constructor() { }

  ngOnInit() {
    console.log(this.dropdownList);
  }

  toggleDropdown() {
    this.showDropDown = !this.showDropDown;
  }
  selectItem(selected) {
    this.selectedItem = selected;
    this.toggleDropdown();
  }
}