import { Register } from '../register/Register';
import { Bus } from './../admin/Bus';
export class CancelTicket{
    ticketNo:number;
    departureDate:Date;
    noOfSeats:number;
    ticketStatus:number;
  
    cancellationDate:Date;
    refundAmount:number;
    totalFare:number;
    emailId:string;
    phoneNo:string;
    bus:Bus;
    user:Register;

    constructor(departureDate:Date, ticketNo:number,  noOfSeats:number, ticketStatus:number, cancellationDate:Date, refundAmount:number, totalFare:number,
        emailId:string, phoneNo:string, bus:Bus, user:Register){
             this.ticketNo = ticketNo;
             this.departureDate = departureDate;
            this.noOfSeats = noOfSeats;
            this.ticketStatus = ticketStatus;
           
            this.cancellationDate = cancellationDate;
            this.refundAmount = refundAmount;
            this.totalFare = totalFare;
            this.emailId = emailId;
            this.phoneNo = phoneNo;
            this.bus = bus;
            this.user = user;
    }

    setBus(bus:Bus){
        this.bus = bus;
    }

    getBus():Bus{
        return this.bus;
    }
    getTick():number{
        return this.ticketNo;
    }
}