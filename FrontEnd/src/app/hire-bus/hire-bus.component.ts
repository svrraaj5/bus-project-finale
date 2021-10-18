import { Bus } from './../admin/Bus';
import { Router } from '@angular/router';
import { BusService } from './../bus.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hire-bus',
  templateUrl: './hire-bus.component.html',
  styleUrls: ['./hire-bus.component.css']
})
export class HireBusComponent implements OnInit {
  from:string = sessionStorage.getItem('from');
  to:string = sessionStorage.getItem('to');
  depDate:string = sessionStorage.getItem('date');
  ds:number = Number(sessionStorage.getItem('driverStatus'));
  dst:string;
  
  //buses:Bus;
  busId:number;
  bus:Bus[] = new Array();
  date:Date;

  bus1:Bus;
  id:number;
  source:string;
  destination:string;
  DateOfJrny:string;
  arrivalTime:string;
  departureTime:string;
  seat:number=30;
  fare:number;
  totalFare:number;
  constructor(private service:BusService, private router: Router) { }

  ngOnInit(): void {

    this.service.getbusbyFromToDateCB(this.from,this.to,this.depDate,1).subscribe(data =>{
      this.bus=data;
    });

  }
  select(buses){
    alert(JSON.stringify(buses));
    //alert(JSON.stringify(buses.source));
    sessionStorage.setItem('busid',buses.id);
    sessionStorage.setItem('bussrc',buses.source);
    sessionStorage.setItem('busdest',buses.destination);
    sessionStorage.setItem('busdd',buses.departureDate);
    sessionStorage.setItem('busbf',buses.baseFare);
    sessionStorage.setItem('busat',buses.arrivalTime);
    sessionStorage.setItem('busdt',buses.departureTime);

    this.id=buses.id;
    this.source=buses.source;
    this.destination=buses.destination;
    this.DateOfJrny=buses.departureDate;
    this.arrivalTime=buses.arrivalTime;
    this.departureTime=buses.departureTime;

    //this.router.navigate(['seat-layout']);
    if(this.ds==1){
      this.dst="Yes";
      this.totalFare=buses.baseFare+500;
    }else{
      this.dst="No";
      this.totalFare=buses.baseFare;
    }
    sessionStorage.setItem('fare',this.totalFare.toString());
    sessionStorage.setItem('seat',this.seat.toString());
    document.getElementById('show1').style.display = 'block';
  }

  proceed(){
    this.router.navigate(['payment-portal']);
  }
}
