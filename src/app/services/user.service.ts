import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  public saveUser(payload) {
    return this.httpClient.post('/nldc/addUser', payload);
  }

  public loginUser(payload) {
    return this.httpClient.post('/nldc/login', payload);
  }

}
