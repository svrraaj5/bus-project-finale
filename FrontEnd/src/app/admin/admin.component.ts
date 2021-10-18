import { AdminloginService } from './../adminlogin.service';
import { AdminLogin } from './../login/AdminLogin';
import { BusService } from './../bus.service';
import { Bus } from './Bus';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  id: number;
  submitted: boolean;
  addBusForm: FormGroup;
  updateBusForm: FormGroup;
  deleteBusForm: FormGroup;
  removeBusForm: FormGroup;
  email:string;
  Bus1: Bus[];
  admin:AdminLogin[] = new Array();
  bs:number;
  cbs:number;
  heroes = ['Windstorm', 'Bombasto', 'Magneta', 'Tornado'];

  constructor(private fb: FormBuilder, private router: Router, private service: BusService, private adminservice:AdminloginService) {
    this.Bus1 = new Array();
    
  }

  ngOnInit(): void {
    if (localStorage.getItem("adminname") != null) {
      this.addBusForm = this.fb.group({
        busId: ['', Validators.required],
        source: ['', Validators.required],
        destination: ['', Validators.required],
        arrivalTime: ['', Validators.required],
        departureTime: ['', Validators.required],
        // arrivalDate: ['', Validators.required],
        // departureDate: ['', Validators.required],
        // availableSeat: ['', Validators.required],
        totalSeat: ['', Validators.required],
        baseFare: ['', Validators.required],
        busStatus: [''],
        coachBusStatus: ['']

      });
      this.updateBusForm = this.fb.group({
        busId: ['', Validators.required],
        source: ['', Validators.required],
        destination: ['', Validators.required],
        arrivalTime: ['', Validators.required],
        // arrivalDate: ['', Validators.required],
        departureTime: ['', Validators.required],
        // departureDate: ['', Validators.required],
        // availableSeat: ['', Validators.required],
        totalSeat: ['', Validators.required],
        baseFare: ['', Validators.required],
        busStatus: [''],
        coachBusStatus: [''],

      });
      this.deleteBusForm = this.fb.group({
        busId: ['', Validators.required],
        departureDate: ['', Validators.required]
      });
      this.removeBusForm = this.fb.group({
        busId: [''],
        departureDate: [''],
        busStatus: [''],

      });

      this.service.getbus().subscribe(data => {
        this.Bus1 = data;
      });

      this.adminservice.getAdmins().subscribe(data => {
        this.admin = data;
      });
      
      this.email = localStorage.getItem("adminname");
      
      for(let ad of this.admin){
        if(this.email==ad.emailId){
          //alert(ad.password);
        }
      }


    } else {
      this.router.navigate(['login-page']);
    }
  }

  count() {
    var counter;
    if (localStorage.count) {
      counter = Number(localStorage.count) + 1;
    } else {
      counter = 1;
    }
    localStorage.setItem("count", counter);
  }

  busid: number;

  addBus(): void {
    if(this.addBusForm.controls.busStatus.value==true){
      this.bs=1;
    }else{
      this.bs=0;
    }

    if(this.addBusForm.controls.coachBusStatus.value==true){
      this.cbs=1;
    }else{
      this.cbs=0;
    }
    let buses1: Bus = new Bus(this.addBusForm.controls.busId.value, this.addBusForm.controls.source.value,
      this.addBusForm.controls.destination.value,
      this.addBusForm.controls.arrivalTime.value, this.addBusForm.controls.departureTime.value, 
     this.addBusForm.controls.totalSeat.value,
      this.addBusForm.controls.baseFare.value, this.bs)

    this.submitted = true;
    if (this.addBusForm.invalid) {
      return;
    }

    this.service.addbus(buses1).subscribe(data => {
      //alert("data: " + JSON.stringify(data));
      this.Bus1.push(buses1);
    })

    /*this.service.addbus(this.addBusForm.value)
      .subscribe( data => {
        this.router.navigate(['list-user']);
      });*/

      location.reload();
  }
  updateBus(): void {
    if(this.updateBusForm.controls.busStatus.value==true){
      this.bs=1;
    }else{
      this.bs=0;
    }
    
    // if(this.updateBusForm.controls.coachBusStatus.value==true){
    //   this.cbs=1;
    // }else{
    //   this.cbs=0;
    // }

    let buses1: Bus = new Bus(this.updateBusForm.controls.busId.value, this.updateBusForm.controls.source.value,
      this.updateBusForm.controls.destination.value,
      this.updateBusForm.controls.arrivalTime.value, this.updateBusForm.controls.departureTime.value, 
     this.updateBusForm.controls.totalSeat.value,
      this.updateBusForm.controls.baseFare.value, this.bs)


    this.service.updateBus(buses1).subscribe(data => {
      //alert("data: " + JSON.stringify(data));
    });
    location.reload();
  }
  deleteBus(): void {
    let result = confirm('Do you want to delete the Bus?')
    if (result) {
      this.service.deleteBus(this.deleteBusForm.controls.busId.value, this.deleteBusForm.controls.departureDate.value)
        .subscribe(data => {
          alert(this.deleteBusForm.controls.busId.value + " is deleted");
        });
    }
    //location.reload();
  }

  removeBus(): void {
    if(this.removeBusForm.controls.busStatus.value==true){
      this.bs=1;
    }else{
      this.bs=0;
    }
    
    let BUS: Bus ;
    this.busid = this.removeBusForm.controls.busId.value;
    for (let i = 0; i < this.Bus1.length; i++) {
      if (this.busid == this.Bus1[i].id) {
        BUS = new Bus(this.Bus1[i].id, this.Bus1[i].source, this.Bus1[i].destination, this.Bus1[i].arrivalTime, this.Bus1[i].departureTime, this.Bus1[i].totalSeat,this.Bus1[i].baseFare,this.bs);
      }
    }
    this.service.updateBus(BUS).subscribe(data => {
      //alert("data: " + JSON.stringify(data));
    });
    location.reload();
  }

  show(id) {
    for (var i = 1; i <= 5; i++) {
      document.getElementById('choice' + i).style.display = 'none';
      document.getElementById('choice' + i).style.paddingTop = '10px';
    }
    document.getElementById('choice' + id).style.display = 'block';
    //alert(JSON.stringify(this.admin))
  }

  Logout(): void {
    if (localStorage.getItem("adminname") != null) {
      localStorage.removeItem("adminname");
      this.router.navigate(['login-page']);
    }
  }

  openNav() {
    document.getElementById("mySidenav").style.width = "250px";
  }
  
  /* Set the width of the side navigation to 0 */
  closeNav() {
    document.getElementById("mySidenav").style.width = "0";
  }
}
