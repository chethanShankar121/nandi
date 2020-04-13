import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-widget-headers',
  templateUrl: './widget-headers.component.html',
  styleUrls: ['./widget-headers.component.css']
})
export class WidgetHeadersComponent implements OnInit {
  @Input() headerText: string;
  constructor() { }

  ngOnInit() {
  }

}
