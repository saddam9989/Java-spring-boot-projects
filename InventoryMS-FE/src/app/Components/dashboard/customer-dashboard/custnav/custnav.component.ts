import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-custnav',
  templateUrl: './custnav.component.html',
  styleUrls: ['./custnav.component.css']
})
export class CustnavComponent implements OnInit {

  constructor(private router:Router) { }
  @Input() custName='';
  @Input() custId = ''
  id = '';
  name = '';
  ngOnInit(): void {
    // this.id = this.custId;
    // this.name = this.custName;
    this.id =localStorage.getItem("customerId") || ''
    this.name = localStorage.getItem("customerName") || ''
  }
  goToProfile(){
    console.log(this.id+" from customer header going to profile");
    this.router.navigate(['/customer-profile',this.id]);
  }
}