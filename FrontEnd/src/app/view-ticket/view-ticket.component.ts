import { Component, OnInit, VERSION } from '@angular/core';
import { Reservation } from '../payment/Reservation';
import { ReservationService } from '../reservation.service';

@Component({
  selector: 'app-view-ticket',
  templateUrl: './view-ticket.component.html',
  styleUrls: ['./view-ticket.component.css']
})
export class ViewTicketComponent implements OnInit {

  journeyDate: string = sessionStorage.getItem("busdd");
  resv:Reservation;
  email:string;
  ticNo:number;

  constructor(private resService:ReservationService) { }

  ngOnInit(): void {

    this.ticNo=Number(sessionStorage.getItem('ticketNo'));

    this.resService.getReservationBytno(this.ticNo).subscribe(data =>{
       this.resv=data;
       });
  }

  

}
