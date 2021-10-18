import { Reservation } from '../payment/Reservation';
export class Seat{
    serialNo:number;
    seatId:number[];
    reserve:Reservation;
    // passName:String;
    // passAge:number;

  
    constructor(seatId:number[], reserve:Reservation){
        this.seatId = seatId;
        this.reserve = reserve;
        // this.passName= passName;
        // this.passAge= passAge;
    }
}