import { ExtraServices } from './extra.service';
import { ErrorHandlingService } from './error-handling.service';
import { CONFIGURATIONS } from './../../config/configurations';
import { environment } from './../../environments/environment';
import { Observable, observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { catchError } from 'rxjs/operators';

@Injectable()
export class CommonResponseService {
    envName;
    baseUrl;
    constructor(
        private http: HttpClient,
        private errorHandling: ErrorHandlingService,
        private extras: ExtraServices) {
        this.envName = environment.envName;
        if (this.envName === 'dev') {
            this.baseUrl = CONFIGURATIONS.domains.DEV_BASE_URL;
        } else if (this.envName === 'prod') {
            this.baseUrl = CONFIGURATIONS.domains.PROD_BASE_URL;
        }
    }
    getData(url, method, payLoad = {}, queryParams = {}, headers = {}): Observable<any> {
        // const updatedUrl = this.formatUrl(url, queryParams);
        const updatedUrl = url;
        if (method.toLowerCase() === 'get') {
            const observable = this.http.get(updatedUrl, headers).pipe(
                map(response => {
                    return JSON.parse(JSON.stringify(response));
                }),
                catchError(error => this.errorHandling.handleAPIError(error)));
            return observable;
        } else if (method.toLowerCase() === 'post') {
            const observable = this.http.post(updatedUrl, payLoad, headers).pipe(
                map(response => {
                    return JSON.parse(JSON.stringify(response));
                }),
                catchError(error => this.errorHandling.handleAPIError(error)));
            return observable;
        } else if (method.toLowerCase() === 'put') {
            const observable = this.http.put(updatedUrl, payLoad, headers).pipe(
                map(response => {
                    if (!response) {
                        return response;
                    }
                    return response ? JSON.parse(JSON.stringify(response)) : response;
                }),
                catchError(error => this.errorHandling.handleAPIError(error)));

            return observable;
        } else if (method.toLowerCase() === 'delete') {
            const httpObservable = this.http.delete(updatedUrl, headers).pipe(
                map(response => {
                    return response ? JSON.parse(JSON.stringify(response)) : response;
                }),
                catchError(error => this.errorHandling.handleAPIError(error)));

            return httpObservable;
        }
    }

    postBlobData(url, payload) {
        const httpObservable = this.http.post(url, payload, {
            responseType: 'blob'
        }).pipe(
            map(response => {
                return response;
            }),
            catchError(error => this.errorHandling.handleAPIError(error)));

        return httpObservable;
    }
    formatUrl(url, queryParams) {

        let updatedUrl = url;
        updatedUrl = updatedUrl.replace('{{baseUrl}}', this.baseUrl);
        if (url.indexOf('/api/') !== 0 && Object.keys(queryParams).length !== 0) {
            updatedUrl += this.convertQueryParametersToString(queryParams);
        }

        return updatedUrl;
    }
    convertQueryParametersToString(queryParams: any) {
        let queryParamString = '';
        if (!this.extras.isObjectEmpty(queryParams)) {
            queryParamString += '?';
            const queryArray = Object.keys(queryParams);
            queryArray.sort();
            queryArray.forEach((param) => {
                queryParamString += (queryParams[param] !== '' && queryParams[param] !== undefined) ? param + '=' + encodeURIComponent(queryParams[param]) + '&' : '';
            });
            if (queryParamString[queryParamString.length - 1] === '&') {
                queryParamString = queryParamString.substr(0, queryParamString.length - 1);
            }
        }
        return queryParamString;
    }
}