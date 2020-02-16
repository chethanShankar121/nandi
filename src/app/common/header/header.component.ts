import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  headerItems = ["Chethan", "chethan", "chethan"];
  showDropDown = false;

  @Output() contextualMenuToggler: any = new EventEmitter();

  constructor() { }
  ngOnInit() {
  }
  toggleContextualMenu() {
    this.showDropDown = !this.showDropDown;
    this.contextualMenuToggler.emit(this.showDropDown);
  }
}
