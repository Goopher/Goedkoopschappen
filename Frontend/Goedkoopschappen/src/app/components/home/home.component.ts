import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

@ViewChild('slideshow') slideshow: ElementRef;

  imageUrlArray = [
    'https://static.pexels.com/photos/811101/pexels-photo-811101.jpeg',
    'https://static.pexels.com/photos/264636/pexels-photo-264636.jpeg',
    'https://static.pexels.com/photos/3008/drinks-supermarket-cans-beverage.jpg'    
  ]

  constructor() { 

    
  }

  ngOnInit() {
    
  }

}
