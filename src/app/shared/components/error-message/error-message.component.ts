import { messages } from './../../constants/message';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-error-message',
  templateUrl: './error-message.component.html',
  styleUrls: ['./error-message.component.css']
})
export class ErrorMessageComponent implements OnInit {
  @Input() errorMessage = '';
  fetchedMessage;
  constructor() { }

  ngOnInit() {
    this.fetchedMessage = messages[this.errorMessage];
    if (!this.fetchedMessage) {
      this.fetchedMessage = {
        title: 'Uh-oh!',
        description: this.errorMessage
      };
    }
  }

}
