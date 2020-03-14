import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ErrorMatcher, MyErrorStateMatcher, errorMessages } from '../../shared/commmonConfiguration/errorMatcher';
import { UserService } from 'src/app/services/user.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit, OnDestroy {

  forms: any;
  matcher: MyErrorStateMatcher = new MyErrorStateMatcher();
  errors: any = errorMessages;
  subscribeList: Array<Subscription> = [];

  constructor(private fb: FormBuilder, private userService: UserService, private router: Router) {
    this.forms = this.fb.group({
      selectUser: ['', [Validators.required]],
      firstName: ['', [Validators.required, Validators.pattern('[a-zA-z ]*'), Validators.maxLength(60), Validators.minLength(5)]],
      lastName: ['', [Validators.required, Validators.pattern('[a-zA-z ]*'), Validators.maxLength(60), Validators.minLength(5)]],
      phoneNumber: ['', [Validators.required, Validators.pattern('[0-9]*'), Validators.maxLength(15), Validators.minLength(5)]],
      email: ['', [Validators.required, Validators.email, Validators.maxLength(120), Validators.minLength(10)]],
      password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(60)]],
      repeatPassword: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(60), ErrorMatcher.matchValues('password')]]
    });
   }

  ngOnInit() {
  }

  public signUpUser() {
    if (this.forms.valid) {
      this.subscribeList.push(this.userService.saveUser(this.processFormData()).subscribe(response => {
        if(response['responseStatus'] === 200) {
          alert("Successfully Added");
          this.router.navigateByUrl("/home/login");
        }
      }));
    }
  }

  private processFormData() {
    return {
      accessRole: parseInt(this.forms.get('selectUser').value),
      firstName: this.forms.get('firstName').value,
      lastName: this.forms.get('lastName').value,
      phone: this.forms.get('phoneNumber').value,
      email: this.forms.get('email').value,
      password: this.forms.get('password').value,
    };
  }

  ngOnDestroy() {
    this.subscribeList.forEach(subscription => subscription.unsubscribe());
  }

}
