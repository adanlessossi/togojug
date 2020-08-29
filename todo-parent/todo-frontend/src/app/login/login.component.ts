import { Component, OnInit } from '@angular/core';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'Bernard';
  password = '';
  errorMessage = 'Invalid credentials';
  invalidLogin = false;

  constructor(private router: Router) { }

  ngOnInit() {
  }

}
