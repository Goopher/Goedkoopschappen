import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class AuthenticationService {

  constructor(private http:HttpClient ) { }

  signupUser(username: string, password: string) {
    let headers = {
      "username": username,
      "password": password
    }
    return this.http.post("http://localhost:8080/api/register", headers)
  }

}
