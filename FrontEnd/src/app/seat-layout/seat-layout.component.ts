import { Router } from '@angular/router';
import { Bus } from './../admin/Bus';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Seat } from './Seat';
import { SeatService } from '../seat.service';

@Component({
  selector: 'app-seat-layout',
  templateUrl: './seat-layout.component.html',
  styleUrls: ['./seat-layout.component.css']
})
export class SeatLayoutComponent implements OnInit {
  
  seat:Seat;
  constructor(private router:Router,private service:SeatService) {
   }

  noOfSeats: number=0;
  selectedSeats:any;
  seatcolor:Array<string>=[];
  seats:Array<number>=[];
  disable:Array<string>=[];
 cost:any;
 seatsBookingcost:number=0;
 busId:number = Number(sessionStorage.getItem('busid'));
 depDate:string = sessionStorage.getItem('date');
  s:Array<boolean>=[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false];
  
  ngOnInit(): void {
    // this.service.getCostBybusId(this.bus_id).subscribe(
    //   data=>{
    //     this.cost=data;
    //     console.log(this.cost);
    //   },
    //   error=>{
    //      console.log(error);
    //   }
    // )
    this.service.getSeatByIdDate(this.busId,this.depDate).subscribe(
      data=>{
        this.selectedSeats=data;
        console.log(this.selectedSeats);
        for(let i of this.selectedSeats)
        {
          this.seatcolor[i-1]="background-color: crimson";
          this.disable[i-1]="true";
        }
      },
      error=>{
        console.log(error)
      }
    )
  }
  
  seat1(k:any){
    if(this.s[k-1]==false){
    this.seats.push(k);
    this.seatcolor[k-1]="background-color: greenyellow;";
   this.noOfSeats++;
    console.log(this.seats);
    this.s[k-1]=true;
  }
  else{
    this.seatcolor[k-1]="background-color: rgba(240, 255, 240, 0.562);";
 
    for(let i=0;i<this.seats.length;i++)
    {
      if(this.seats[i]==k)
            this.seats.splice(i,1);
    }
    this.noOfSeats--;
    console.log(this.seats);
    this.s[k-1]=false;
  }
  this.seatsBookingcost=this.cost * this.seats.length; 
}
  makePayment(){
    if(this.seats.length>0){  
      // for(let i=0;i<this.seats.length;i++)
      // {       
      //  this.seat.seatId=this.seats[i];
      //  this.seat.reserve.ticketNo=null;
      //  this.service.addSeat(this.seat).subscribe(
      //   (data)=>{
      //     console.log(data);
      //   if(data)
      //   alert("Seat Added");
      // },
      // (error)=>{
      //   console.log(error);
      // })
      //
    //}    
    sessionStorage.setItem("selectedSeats", JSON.stringify(this.seats));
    sessionStorage.setItem("noOfSeats", this.seats.length.toString());
    this.router.navigate(['passenger'])
    }
  }

back(){
    this.router.navigate(['search-bus-page']);
  }

}
