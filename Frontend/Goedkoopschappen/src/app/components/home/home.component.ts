import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

@ViewChild('slideshow') slideshow: ElementRef;

  imageUrlArray = [
    'https://upload.wikimedia.org/wikipedia/commons/0/0d/Jumbo_Supermarkten.jpg',
    'https://upload.wikimedia.org/wikipedia/commons/0/0d/Jumbo_Supermarkten.jpg',
    'https://upload.wikimedia.org/wikipedia/commons/0/0d/Jumbo_Supermarkten.jpg'    
  ]

  constructor() { 

    
  }

  ngOnInit() {
    
  }

}
