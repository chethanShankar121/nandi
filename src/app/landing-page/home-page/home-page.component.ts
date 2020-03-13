import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  constructor() {
    window.addEventListener('scroll', function(e){
      const textContainer = document.querySelector('.overlay-text-container')[0] as HTMLElement;
      console.log(textContainer);
      const scrolled = window.pageYOffset;
      const rate = scrolled * 0.5;
      textContainer.style.transform = "translate3d( 0px, rate, 0px)";

    });

  }

  ngOnInit() {
  }
}
