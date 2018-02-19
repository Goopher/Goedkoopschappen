import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { AuthenticationService } from '../../services/authentication.service'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  registration_status : string;

  constructor(private authService: AuthenticationService) { }

  ngOnInit() {
  }

  onSignup(form: NgForm) {
    const username = form.value.username;
    const password = form.value.password;
    this.authService.requestToken(username, password, "password")
    .subscribe(
    data=> this.registration_status = "Registration succesful",
    error => this.registration_status = "Username already exists");
  }

}
