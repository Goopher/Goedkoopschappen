import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable()
export class AuthenticationService {

  constructor(private http:HttpClient ) { }

  signupUser(username: string, password: string) {
    let headers = {
      "username": username,
      "password": password
    }
    return this.http.post("http://localhost:8080/api/register", headers);
  }

  requestToken(username:string, password:string, grant_type:string){
    let basicAuth = btoa("goedkoopschappen" + ":" + "goedkoopschappen");

    let headers = new HttpHeaders();
    headers = headers.append("Authorization", 'Basic ' + basicAuth)
    headers = headers.append("Content-Type", "application/x-www-form-urlencoded")
    headers = headers.append("Accept", "application/json")
    const body = JSON.stringify({username: username, password: password, grant_type:'password'});
    console.log(headers)
    console.log(body)
    return this.http.post("http://localhost:8080/oauth/token",body, {headers: headers});


  }npm

}
