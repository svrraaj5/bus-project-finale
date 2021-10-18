//import { Reservation } from './../payment/Reservation';
export class Payment{
    paymentId:number;
    //addedFare:number;
    bookingDate:Date;
    chargedFare:number;
    paymentMethod:string;

    constructor( bookingDate:Date, chargedFare:number,
        paymentMethod:string){
            //this.addedFare=addedFare;
            this.bookingDate=bookingDate;
            //this.dayDifference=dayDifference;
            this.chargedFare=chargedFare;
            this.paymentMethod=paymentMethod;
    }
}