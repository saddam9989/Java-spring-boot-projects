import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent implements OnInit {
  
  @Input() adminname='';
  constructor(private router:Router) { }
  name = '';
  ngOnInit(): void {
    this.adminname = localStorage.getItem("adminname") || '';
    this.name =this.adminname;
    console.log(this.name)
  }
}
 