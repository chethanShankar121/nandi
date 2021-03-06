import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginStateService {

  private messageSource = new BehaviorSubject({});
  currentMessage = this.messageSource.asObservable();

  constructor() { }

  changeLoginState(updatedState: Object) {
    this.messageSource.next(updatedState);
  }

  logOutUser() {
    this.messageSource.next({});
  }

}
