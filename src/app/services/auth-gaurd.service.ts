import { Injectable, OnDestroy } from '@angular/core';
import { LoginStateService } from './login-state.service';
import { CanActivate } from '@angular/router';
import { Observable, Subscription } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService implements CanActivate, OnDestroy{

  authStage: Subscription;
  authorization: boolean;

  constructor(private loginState: LoginStateService) {
    this.authStage = this.loginState.currentMessage.subscribe(
      response => {
        if (response['setSessionID']) {
          this.authorization = true;
        } else {
          this.authorization = false;
        }
      }
    );
  }

  canActivate() {
    return this.authorization;
  }

  ngOnDestroy() {
    this.authStage.unsubscribe();
  }


}
