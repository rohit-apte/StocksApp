import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  path = '../../assets/img/';
  images = [
    {
      url: this.path + 'img1.jpg',
      title: `Welcome to Stocks Application`,
      desc: ''
    },
    {
      url: this.path + 'img2.jpg',
      title: `Welcome to Stocks Application`,
      desc: ''
    },
    {
      url: this.path + 'img3.jpg',
      title: `Welcome to Stocks Application`,
      desc: ''
    },
    {
      url: this.path + 'img4.jpg',
      title: `Welcome to Stocks Application`,
      desc: ''
    }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
