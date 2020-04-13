import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-drop-down',
  templateUrl: './drop-down.component.html',
  styleUrls: ['./drop-down.component.css']
})
export class DropDownComponent implements OnInit {
  @Input() dropdownLabel;
  @Input() dropdownList;
  @Input() disabled = false;
  @Output() itemSelected = new EventEmitter();
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
    this.itemSelected.emit(this.selectedItem);
  }
}
