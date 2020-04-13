import { FormGroup, FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-signup-verification',
  templateUrl: './signup-verification.component.html',
  styleUrls: ['./signup-verification.component.css']
})
export class SignupVerificationComponent implements OnInit {
  verification: any;
  emailId: any;
  phone: any;
  emailVerified: any;
  phoneVerified: any;
  emailChanged = false;
  phoneChanged = false;
  constructor(
    private router: Router
  ) {
    this.routerParam();
  }


  form = new FormGroup({
    email: new FormControl(),
    emailOtp: new FormControl(),
    phoneNum: new FormControl(),
    phoneOtp: new FormControl()
  });
  get email() {
    return this.form.get('email');
  }
  get emailOtp() {
    return this.form.get('emailOtp');
  }
  get phoneNum() {
    return this.form.get('phoneNum');
  }
  get phoneOtp() {
    return this.form.get('PhoneOtp');
  }
  ngOnInit() {
  }
  routerParam() {
    const queryParams = this.router.routerState.snapshot.root.queryParams;
    this.verification = queryParams['verification'];
    this.emailId = queryParams['email'];
    this.phone = queryParams['phone'];
    this.emailVerified = queryParams['emailVerified'];
    this.phoneVerified = queryParams['phoneVerified'];
  }

  changeDetector(event, changeType) {
    console.log(event);
    if (changeType === 'email-change') {
      if (event.target.value !== this.emailId) {
        this.emailChanged = true;
      } else {
        this.emailChanged = false;
      }
    }
    if (changeType === 'phone-change') {
      if (event.target.value !== this.phone) {
        this.phoneChanged = true;
      } else {
        this.phoneChanged = false;
      }
    }

  }
}
