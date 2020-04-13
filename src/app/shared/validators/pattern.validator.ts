import { AbstractControl, ValidationErrors } from '@angular/forms';
export class patternValidators {
    static cannotContainSpace(control: AbstractControl): ValidationErrors | null {
        if ((control.value as String).indexOf(' ') >= 0) {
            return { cannotContainSpace: true }
        } else {
            return null;
        }
    }
    static shouldBeAlphabet(control: AbstractControl): ValidationErrors | null {
        if ((control.value as string).length > 0) {
            const regex = /^[a-zA-Z]*$/;
            const value = control.value as string;
            if (regex.test(value)) {
                return null;
            } else {
                return { shouldBeAlphabet: true };
            }
        }
    }
    static shouldBeNumbers(control: AbstractControl): ValidationErrors | null {
        if ((control.value as string).length > 0) {
            if ((control.value as string).match(/^[0-9]*$/)) {
                return null;
            } else {
                return { shouldBeNumbers: true };
            }
        }
    }
    static emailPattern(control: AbstractControl): ValidationErrors | null {
        if ((control.value as string).length > 1) {
            if ((control.value as string).match(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)) {
                return null;
            } else {
                return { invalidEmail: true };
            }
        }
    }
}