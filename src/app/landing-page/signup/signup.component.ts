import { ExtraServices } from './../../services/extra.service';
import { ErrorHandlingService } from './../../services/error-handling.service';
import { environment } from './../../../environments/environment';
import { CommonResponseService } from './../../services/commonResponse.service';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { UserService } from 'src/app/services/user.service';
import { errorMessages, MyErrorStateMatcher } from '../../shared/commmonConfiguration/errorMatcher';
import { patternValidators } from './../../shared/validators/pattern.validator';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit, OnDestroy {

  matcher: MyErrorStateMatcher = new MyErrorStateMatcher();
  errorMessage;
  showVerifiactionWidget: boolean = false;
  apiStatus;
  addUserObj = {
    response: null,
    status: null,
    error: null
  };
  phone;
  emailId: any;
  verification;
  emailVerified = false;
  phoneVerified = false;
  private addUserSubscription: Subscription;
  private sendOtpSusbscription: Subscription;
  userId: any;

  constructor(
    private userService: UserService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private commonResponseService: CommonResponseService,
    private errorHandling: ErrorHandlingService,
    private extras: ExtraServices
  ) {
    this.routerParam();
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
  routerParam() {
    const queryParams = this.router.routerState.snapshot.root.queryParams;
    this.verification = queryParams['verification'];
    this.emailId = queryParams['email'];
    this.phone = queryParams['phone'];
    if (this.emailId && this.phone && this.verification && this.verification === 'true') {
      this.apiStatus = 1;
      this.showVerifiactionWidget = true;
    }
  }
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
    try {
      if (this.form.valid) {
        this.apiStatus = 0;
        const url = environment.addUser.url;
        const method = environment.addUser.method;
        const payload = this.processFormData();
        this.addUserSubscription = this.commonResponseService.getData(url, method, payload)
          .subscribe(response => {
            if (response['responseStatus'] === 200) {
              if (!this.extras.isObjectEmpty(response.addtionalInfo.additonalDetails)) {
                this.apiStatus = 1;
                const params = {
                  verification: true,
                  email: response.addtionalInfo.additonalDetails.email,
                  phone: response.addtionalInfo.additonalDetails.phone,
                  emailVerified: response.addtionalInfo.additonalDetails.isEmailVerified,
                  phoneVerified: response.addtionalInfo.additonalDetails.isPhoneNumberVerified
                };
                this.userId = response.addtionalInfo.additonalDetails.id;
                this.router.navigate([], {
                  relativeTo: this.activatedRoute,
                  queryParams: params
                });
                // this.showVerifiactionWidget = true;
                this.sendOTP(this.userId);
              }
            }
          }, error => {
            this.apiStatus = -1;
            this.errorMessage = 'userSignupError';
            this.errorHandling.handleAPIError(error);
          });
      }
    } catch (error) {
      this.apiStatus = -1;
      this.errorMessage = 'jsError';
      this.errorHandling.handleJavascriptError(error);
    }
  }
  sendOTP(userId) {
    try {
      if (userId) {
        const url = environment.sendOtp.url;
        const method = environment.sendOtp.method;
        const id = userId;
        const payload = {
          operation: 'both',
          userId: id
        };
        this.sendOtpSusbscription = this.commonResponseService.getData(url, method, payload)
          .subscribe(response => {
            if (response.responseStatus === 2000) {
              this.showVerifiactionWidget = true;
              alert('OTP sent to your Email and Phone Number');
            } else {
              this.showVerifiactionWidget = true;
              alert('Details added Successfully, but, could not send OTP.\n Please resend OTP');
            }
          }, error => {
            this.showVerifiactionWidget = true;
            alert('Details added Successfully, but, could not send OTP.\n Please resend OTP');
          });
      }
    } catch (error) {
      this.showVerifiactionWidget = true;
      alert('Details added Successfully, but, could not send OTP.\n Please resend OTP');
      this.errorMessage = this.errorHandling.handleJavascriptError(error);
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
    try {
      if (this.addUserSubscription) {
        this.addUserSubscription.unsubscribe();
      }
      if (this.sendOtpSusbscription) {
        this.sendOtpSusbscription.unsubscribe();
      }
    } catch (error) {
      this.errorHandling.handleJavascriptError(error);
    }
  }
}
