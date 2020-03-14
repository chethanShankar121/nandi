import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  showContextualMenu = false;
  showLoginDropDown = false;

  @Output() contextualMenuToggler: any = new EventEmitter();

  constructor(
    private router: Router
  ) {

  }
  ngOnInit() {
  }
  toggleContextualMenu() {
    this.showContextualMenu = !this.showContextualMenu;
    this.contextualMenuToggler.emit(this.showContextualMenu);
  }
  toggleDropdown() {
    this.showLoginDropDown = !this.showLoginDropDown;
  }
  navigateTo(page) {
    if (page === 'signup') {
      this.router.navigate(
        ['home', 'signup'],
        {}
      ).then(response => {
        console.log('info', 'Successfully navigated to signup page: ' + response);
      });
    }
    if (page === 'login') {
      this.router.navigate(
        ['home', 'login'],
        {}
      ).then(response => {
        console.log('info', 'Successfully navigated to login page: ' + response);
      });
    }
  }
}
