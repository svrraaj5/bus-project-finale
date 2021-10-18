import { Router } from '@angular/router';
import { BusService } from './../bus.service';
import { Bus } from './../admin/Bus';
import { ReservationService } from './../reservation.service';
import { Reservation } from './../payment/Reservation';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-payment-successful',
  templateUrl: './payment-successful.component.html',
  styleUrls: ['./payment-successful.component.css']
})
export class PaymentSuccessfulComponent implements OnInit {
  res:Reservation[] = new Array();
  bus:Bus;
  busid:number;
  depDate:string;
  constructor(private service:ReservationService, private busService:BusService, private router:Router) { }

  ngOnInit(): void {
    this.service.getReservation().subscribe(data =>{
      this.res = data;
    });

  }
  back(){
    this.router.navigate(['payment-portal']);
  }
}
