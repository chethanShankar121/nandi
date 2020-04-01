import { patternValidators } from './../../shared/validators/pattern.validator';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
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

  matcher: MyErrorStateMatcher = new MyErrorStateMatcher();
  errors: any = errorMessages;
  subscribeList: Array<Subscription> = [];

  constructor(private userService: UserService, private router: Router) {

  }
  form = new FormGroup({
    selectUser: new FormControl('', [Validators.required]),
    firstName: new FormControl('',
      [Validators.required,
      Validators.maxLength(60),
      Validators.minLength(3),
      patternValidators.cannotContainSpace,
      patternValidators.shouldBeAlphabet
      ]),
    lastName: new FormControl('',
      [Validators.required,
      Validators.maxLength(60),
      patternValidators.shouldBeAlphabet
      ]),
    phoneNumber: new FormControl('',
      [Validators.required,
      Validators.maxLength(15),
      Validators.minLength(5),
      patternValidators.shouldBeNumbers
      ]),
    email: new FormControl('',
      [Validators.required,
      patternValidators.emailPattern,
      Validators.maxLength(120)
      ]),
    password: new FormControl('',
      [Validators.required,
      Validators.minLength(6),
      Validators.maxLength(60)]),
    repeatPassword: new FormControl('',
      [Validators.required]),
  });
  passwordValidator() {
    const condition = this.password.value !== this.repeatPassword.value;
    return condition;
  }
  ngOnInit() {
  }
  get selectUser() {
    return this.form.get('selectUser');
  }
  get firstName() {
    return this.form.get('firstName');
  }
  get lastName() {
    return this.form.get('lastName');
  }
  get phoneNumber() {
    return this.form.get('phoneNumber');
  }
  get email() {
    return this.form.get('email');
  }
  get repeatPassword() {
    return this.form.get('repeatPassword');
  }
  get password() {
    return this.form.get('password');
  }
  public signUpUser() {
    if (this.form.valid) {
      this.subscribeList.push(this.userService.saveUser(this.processFormData()).subscribe(response => {
        if (response['responseStatus'] === 200) {
          alert("Successfully Added");
          this.router.navigateByUrl("/home/login");
        }
      }));
    }
  }

  private processFormData() {
    return {
      accessRole: parseInt(this.selectUser.value),
      firstName: this.firstName.value,
      lastName: this.lastName.value,
      phone: this.phoneNumber.value,
      email: this.email.value,
      password: this.password.value,
    };
  }

  ngOnDestroy() {
    this.subscribeList.forEach(subscription => subscription.unsubscribe());
  }

}
