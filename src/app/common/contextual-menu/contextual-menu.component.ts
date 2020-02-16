import { Component, OnInit, Input, OnChanges, Output, EventEmitter } from '@angular/core';
import { menu } from '../../shared/constants/contextual-menu-list';
@Component({
  selector: 'app-contextual-menu',
  templateUrl: './contextual-menu.component.html',
  styleUrls: ['./contextual-menu.component.css']
})
export class ContextualMenuComponent implements OnInit, OnChanges {
  @Output('closeMenu') closeMenu = new EventEmitter<boolean>();
  contextualMenuList;
  constructor() { }

  ngOnInit() {
    this.contextualMenuList = menu[0].dashboards;
  }
  ngOnChanges() {
  }
  onSelect(item) {
    if(!item.dashboards) {
      this.closeMenu.emit(false);
    }
  }
}
