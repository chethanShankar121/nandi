import { ValidationErrors, AbstractControl, RequiredValidator } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { FormControl, FormGroupDirective, NgForm } from '@angular/forms';

export class ErrorMatcher {

  public static matchValues(
    matchTo: string
  ): (AbstractControl) => ValidationErrors | null {
    return (control: AbstractControl): ValidationErrors | null => {
      return !!control.parent &&
        !!control.parent.value &&
        control.value === control.parent.controls[matchTo].value
        ? null
        : { matched: true };
    };
}
}


export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(
    control: FormControl | null,
    form: FormGroupDirective | NgForm | null
  ): boolean {
    if (!control.pristine && control.invalid) {
      return !control.pristine && control.invalid;
    }
    if (control.touched) {
      return control.invalid;
    }
    return false;
  }
}

export const errorMessages: any = {
  selectUser: 'Please select user type',
  firstName: [
    { type: 'required', message: 'Required' },
    { type: 'pattern', message: 'Please Enter only alphabets' },
    { type: 'maxlength', message: 'FirstName should be only 60 Characters' },
    { type: 'minlength', message: 'FirstName should be atleast 5 characters' }
  ],
  lastName: [
    { type: 'required', message: 'Required' },
    { type: 'pattern', message: 'Please Enter only alphabets' },
    { type: 'maxlength', message: 'LastName should be only 60 Characters' },
    { type: 'minlength', message: 'LastName should be atleast 5 characters' }
  ],
  phoneNumber: [
    { type: 'required', message: 'Required' },
    { type: 'pattern', message: 'Please Enter only numbers' },
    { type: 'maxlength', message: 'Phone Number should be only 15 Characters' },
    { type: 'minlength', message: 'phone Number should be atleast 5 characters' }
  ],
  email: [
    { type: 'required', message: 'Required' },
    { type: 'email', message: 'Please Enter vaild emailId' },
    { type: 'maxlength', message: 'Phone Number should be only 120 Characters' },
    { type: 'minlength', message: 'phone Number should be atleast 10 characters' }
  ],
  password: [
    { type: 'required', message: 'Required' },
    { type: 'maxlength', message: 'Phone Number should be only 60 Characters' },
    { type: 'minlength', message: 'phone Number should be atleast 8 characters' }
  ],
  repeatPassword: [
    { type: 'required', message: 'Required' },
    { type: 'maxlength', message: 'Phone Number should be only 60 Characters' },
    { type: 'minlength', message: 'phone Number should be atleast 8 characters' },
    { type: 'matched', message: 'Passwords didn\'t Matched'}
  ],
};
