import { CancelTicket } from './CancelTicket';
import { PaymentService } from './../payment.service';
import { Router } from '@angular/router';
import { Bus } from './../admin/Bus';
import { BusService } from './../bus.service';
import { Reservation } from './../payment/Reservation';
import { ReservationService } from './../reservation.service';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cancel-ticket',
  templateUrl: './cancel-ticket.component.html',
  styleUrls: ['./cancel-ticket.component.css']
})
export class CancelTicketComponent implements OnInit {
  cancelTicketForm:FormGroup;
  resv:Reservation;
  busId:number;
  dDate:Date;
  seats:number;
  bus:Bus;
  cancelTickets: CancelTicket;
  tNo:number;
  constructor(private fb: FormBuilder, private service:ReservationService, private busService:BusService, private router:Router, private payService:PaymentService) {
   }

  ngOnInit(): void {
    this.cancelTicketForm = this.fb.group({
      emailId: ['', Validators.required],
      ticketNo:['', Validators.required],
    });
    /*this.service.getReservationBytno(this.cancelTicketForm.controls.ticketNo.value).subscribe(data =>{
      this.cancelTickets=data;
    });
    */
  }
cancelTicket()
{
  this.service.getReservationBytno(this.tNo).subscribe(data =>{
    this.resv=data;
  });
  sessionStorage.setItem('ticket',this.cancelTicketForm.controls.ticketNo.value);
  this.router.navigate(['after-cancel']);

}
}
