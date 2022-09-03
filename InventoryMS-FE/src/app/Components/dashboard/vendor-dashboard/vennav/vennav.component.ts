import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vennav',
  templateUrl: './vennav.component.html',
  styleUrls: ['./vennav.component.css']
})
export class VennavComponent implements OnInit {

  @Input() vendorName = '';
  @Input() vendorId = '';
  constructor(private router:Router) { }
  id = '';
  name = '';
  ngOnInit(): void {
    this.id = this.vendorId;
    this.name = this.vendorName;
  }
  goToProfile(){
    console.log(this.id+" from vendor header going to profile");
    this.router.navigate(['/vendor-profile',this.id]);
  }

}