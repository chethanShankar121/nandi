import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  public saveUser(payload) {
    console.log(payload);
    const Headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });
    return this.httpClient.post('/nldc/addUser', payload);
  }

}
