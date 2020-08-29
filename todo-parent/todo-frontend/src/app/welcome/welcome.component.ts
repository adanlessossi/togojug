import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  message = 'Some message';
  welcomeMessage = '';
  name = '';

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.name = this.route.snapshot.params['name'];
  }

  getWelcomeMessage() {

  }

  handleSuccessfulResponse(response){
    //this.welcomeMessage = response.message;
  }

  handleErrorMessage(error){
    //this.welcomeMessage = error.error.message;
  }
}
