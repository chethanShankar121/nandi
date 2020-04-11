import { throwError as observableThrowError } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EXPECTATION_FAILED, SERVICE_UNAVAILABLE, NOT_FOUND } from 'http-status-codes';

@Injectable()
export class ErrorHandlingService {
    constructor() { }

    handleAPIError(httpErrorResponse: any): Observable<any> {
        /* This fucntion is to handle errors generated by API. */
        // Report it to logger
        console.log('info', '***Inside handleAPIError API error, error is:***');
        console.log('error', httpErrorResponse);

        let errorMessage;
        const httpStatusCode = httpErrorResponse.status;

        console.log('error', 'http status code - ' + httpStatusCode);

        switch (httpStatusCode) {
            case EXPECTATION_FAILED:
                if (httpErrorResponse.error && httpErrorResponse.error.errorMessage) {
                    errorMessage = httpErrorResponse.error.errorMessage;
                    break;
                }
                errorMessage = 'apiResponseError';
                break;
            case SERVICE_UNAVAILABLE:
                errorMessage = 'apiResponseError';
                break;
            case NOT_FOUND:
                if (httpErrorResponse.error && httpErrorResponse.error.errorMessage) {
                    errorMessage = httpErrorResponse.error.errorMessage;
                    break;
                }
                errorMessage = 'apiResponseError';
                break;
            case 0:
                // Show user a way to handle certificate issue
                errorMessage = 'apiResponseError';
                console.log('error', 'Certificate issue has occured');
                break;
            default:
                errorMessage = 'apiResponseError';
        }

        return observableThrowError(errorMessage);
    }

    handleJavascriptError(error: any) {
        /* This fucntion is to handle erros generated by Javascript */
        // Report it to logger
        console.log('info', '***Inside javascript error, error is: ***');
        console.log('error', error);
        return 'jsError';
    }

}