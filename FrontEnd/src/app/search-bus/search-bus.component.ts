import { Router } from '@angular/router';
import { BusService } from './../bus.service';
import { Bus } from './../admin/Bus';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search-bus',
  templateUrl: './search-bus.component.html',
  styleUrls: ['./search-bus.component.css']
})
export class SearchBusComponent implements OnInit {
  
  from:string = sessionStorage.getItem('source');
  to:string = sessionStorage.getItem('dest');
  depDate:string = sessionStorage.getItem('date');
  //buses:Bus;
  busId:number;
  bus:Bus[] = new Array();
  date:Date;
  selected:boolean = false;
  //latest_date =this.datepipe.transform(this.depDate, 'dd-MM-YYYY');
  constructor(private service:BusService, private router: Router) {}

  ngOnInit(): void {
   /*alert(sessionStorage.getItem('source'));
    alert(sessionStorage.getItem('dest'));
    alert(sessionStorage.getItem('date'));*/
    this.service.getbusbyFromTo(this.from,this.to).subscribe(data=> {
      this.bus = data;
    });
    
  }

  select(buses){
    //alert(JSON.stringify(buses));
    //alert(JSON.stringify(buses.source));
    sessionStorage.setItem('busid',buses.id);
    sessionStorage.setItem('bussrc',buses.source);
    sessionStorage.setItem('busdest',buses.destination);
    sessionStorage.setItem('busdd',buses.departureDate);
    sessionStorage.setItem('busbf',buses.baseFare);
    sessionStorage.setItem('busat',buses.arrivalTime);
    sessionStorage.setItem('busdt',buses.departureTime);
    this.router.navigate(['seat-layout']);
  }

  back(){
    if (localStorage.getItem("username") != null){
      this.router.navigate(['dashboard']);
    }else{
      this.router.navigate(['']);
    }
  }
}
