import { Reservation } from './../payment/Reservation';
import { ReservationService } from './../reservation.service';
import { RegisterService } from './../register.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Register } from '../register/Register';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  passForm: FormGroup;
  submitted: boolean = false;
  invalidLogin: boolean = false;
  searchForm: FormGroup;
  cancelForm: FormGroup;
  hireBusForm: FormGroup;
  submittedCancel: boolean = false;
  invalidCancel: boolean = false;
  users:Register[];
  user:Register;
  source: string;
  destination: string;
  busDate: Date;
  resv:Reservation[] = new Array();
  rs:Reservation;
  res:Reservation;
  up:boolean=false;
  bh:boolean=false;
  no:number;
  bdt:string;
  date:Date=new Date();
  currDate = new Date().toISOString().slice(0,10);
  constructor(private formBuilder: FormBuilder, private router: Router, private service:RegisterService, private resService:ReservationService ) {
    this.users=new Array();
   }

  onSubmitPass(){
    this.submitted = true;
    if(this.passForm.invalid){
      return;
    }
    if(this.passForm.controls.ps1.value =="mani21"){
          alert("Password Reset Successfully!");
          this.submitted = false;
          this.passForm.controls.ps1.setValue("");
          this.passForm.controls.ps2.setValue("");
    }
    else{
      this.invalidLogin = true;
    }
  }

  onSubmitCancel(){
    this.submittedCancel = true;
    if(this.cancelForm.invalid){
      return;
    }
    // this.resService.getReservationBytno(this.cancelForm.controls.ticketNo.value).subscribe(data =>{
    //   this.res=data;
    // });
    sessionStorage.setItem('ticket',this.cancelForm.controls.ticketNo.value);
    this.router.navigate(['after-cancel']);
  }

  email:string;

  newReg:boolean = true;
  uName:string;
  ds:number=0;
  id:number;
  ngOnInit(): void {
    if(localStorage.getItem("username")!=null){
    this.passForm = this.formBuilder.group({
      ps1: ['', Validators.required],
      ps2: ['', Validators.required]
    });
    this.cancelForm = this.formBuilder.group({
      email: ['', Validators.required],
      ticketNo: ['', Validators.required]
    });
    this.searchForm = this.formBuilder.group({
      from: ['',Validators.required],
      to: ['', Validators.required],
      date: ['', Validators.required]
    });
    this.hireBusForm = this.formBuilder.group({
      source: ['', Validators.required],
      destination: ['', Validators.required],
      depDate: ['', Validators.required],
      driverStatus: ['']
    })
    this.service.getRegistration().subscribe(data=>{
      this.users = data;
    });
    
    

    this.email = localStorage.getItem("username");

    this.resService.getReservationByEmailId(this.email).subscribe(data =>{
      
      this.resv = data;
    });
    
    //alert(this.currDate)
    /*for (let index = 0; index < this.users.length; index++) {
      alert(this.users[index].emailId)
      if(this.email==this.users[index].emailId){
        this.uName=this.users[index].firstName+' '+ this.users[index].lastName;
      }
    }
    /*
    }*/
    this.uName=localStorage.getItem("uname");
    this.service.getRegistrationById(this.email).subscribe(data =>{
      this.user = data;
    })
    
  }else{
  this.router.navigate(['/login-page']);
    
  }
}

  show(id) { 
    
      // for(let u of this.resv){
      //   if(u.bus.departureDate.toString()>=this.currDate){
      //     this.up=true;
      //   }
      //   if(u.bus.departureDate.toString()<this.currDate){
      //     this.bh=true;
      //   }
      // }
      //alert(this.bh) 
    
    for (var i=1;i<=7;i++)
    {
        document.getElementById('choice'+i).style.display = 'none';
        document.getElementById('choice'+i).style.marginTop = '70px';
    }
    if(id==7){
      document.getElementById('search').style.display = 'none';
    }else{
      document.getElementById('search').style.display = 'block';
    }
    document.getElementById('choice'+id).style.display = 'block';
    //alert(JSON.stringify(this.users));
    for(let u1 of this.users){
      if(this.email== u1.emailId){
        //this.uName=u1.firstName+' '+ u1.lastName;
        this.user=u1;
      }
    }
    //alert(this.uName)
}

search(){
    this.source=this.searchForm.controls.from.value;
    this.destination=this.searchForm.controls.to.value;
    this.busDate=this.searchForm.controls.date.value;
    
    sessionStorage.setItem('source',this.searchForm.controls.from.value);
    sessionStorage.setItem('dest',this.searchForm.controls.to.value);
    sessionStorage.setItem('date',this.searchForm.controls.date.value);
    if(this.searchForm.controls.from.value==this.searchForm.controls.to.value){
      alert("Source and Destination should not be same")
    }
    else{
    this.router.navigate(['search-bus-page']);
    }
}

Logout():void{
  if(localStorage.getItem("username")!=null){
    localStorage.removeItem("username");
    this.router.navigate(['login-page']);
  }
} 

searchHb(){
  sessionStorage.setItem('from',this.hireBusForm.controls.source.value);
  sessionStorage.setItem('to',this.hireBusForm.controls.destination.value);
  sessionStorage.setItem('date',this.hireBusForm.controls.depDate.value);
  if(this.hireBusForm.controls.driverStatus.value==true){
    this.ds=1;
  }else{
    this.ds=0;
  }
  sessionStorage.setItem('driverStatus',this.ds.toString());
  this.router.navigate(['hire-bus']);
}
openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

/* Set the width of the side navigation to 0 */
closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}

ticket(no){
  
  sessionStorage.setItem('ticketNo',no);
  // sessionStorage.setItem('bdt',bdt);
  this.router.navigate(['view-ticket']);
  
}
}
