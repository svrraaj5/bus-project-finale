import { CancelTicket } from './../cancel-ticket/CancelTicket';
import { Router } from '@angular/router';
import { ReservationService } from './../reservation.service';
import { Reservation } from './../payment/Reservation';
import { Bus } from './../admin/Bus';
import { BusService } from './../bus.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-after-cancel',
  templateUrl: './after-cancel.component.html',
  styleUrls: ['./after-cancel.component.css']
})
export class AfterCancelComponent implements OnInit {

  tNo: number;
  bid: number;
  dDate: string;
  bus: Bus;
  bus1: Bus;
  resv: Reservation;
  seats: number;
  cTicket: CancelTicket;
  constructor(private resService: ReservationService, private busService: BusService, private router: Router) { }

  ngOnInit(): void {
    this.tNo = Number(sessionStorage.getItem('ticket'));

    this.resService.getReservationBytno(this.tNo).subscribe(data => {
      this.resv = data;
    });
  }
  delete() {
    this.bid = this.resv.bus.id;
    //this.dDate = this.resv.bus.departureDate.toString();
    this.seats = this.resv.noOfSeats;
    

    this.cTicket = new CancelTicket(this.resv.departureDate,this.resv.ticketNo,  this.resv.noOfSeats, 0, new Date(), this.resv.totalFare, 0, this.resv.emailId, this.resv.phoneNo, this.resv.bus, this.resv.user);

    this.resService.updateReservation(this.cTicket).subscribe(data =>{

    });

    this.busService.getBusById(this.bid).subscribe(data => {
      this.bus = data;
    });

    this.busService.updateBusByIdDateSeat(this.bid,this.dDate,this.resv.bus.availableSeat+this.seats,this.bus).subscribe(data =>{

    });
    document.getElementById('ok').style.display = 'block';
  }

  /*ok() {
    this.bus1 = new Bus(this.bus.id, this.bus.source, this.bus.destination, this.bus.arrivalTime, this.bus.departureTime, this.bus.arrivalDate,
      this.bus.departureDate, this.bus.availableSeat + this.seats, this.bus.totalSeat, this.bus.baseFare, this.bus.busStatus, this.bus.coachBusStatus);
    this.busService.updateBus(this.bus1).subscribe(data => {
      //alert(JSON.stringify(this.bus1));
    });
    this.router.navigate(['/'])
  }*/
}

