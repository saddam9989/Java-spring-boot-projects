import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Dealer } from 'src/app/Classes/dealer';
import { LoginService } from 'src/app/Services/login.service';
import { VendorDashboardService } from 'src/app/Services/vendor-dashboard.service';

@Component({
  selector: 'app-vendor-login',
  templateUrl: './vendor-login.component.html',
  styleUrls: ['./vendor-login.component.css']
})
export class VendorLoginComponent implements OnInit {

  dealer: Dealer = new Dealer();
  constructor(private loginService:LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  login(){
    this.loginService.vendorLogin(this.dealer).subscribe(data => {
      if(data!=null){
        alert("Vendor LoggedIn Succefully")
        localStorage.setItem("vendorId",data.vendorId.toString()) 
        localStorage.setItem("vendorName",data.vendorName)
        this.router.navigate(['/vendor-dashboard',data.vendorName,data.vendorId]);
      }else{
        console.log(data)
      }
    },
    error => alert("Please enter correct username and password!"));
};

}
