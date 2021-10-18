export class Bus{
      id:number;
      source: string;
      destination:string;
      arrivalTime: string;
      departureTime:string;
      totalSeat:number;
      baseFare:number;
      busStatus:number;
      availableSeat:number;
     

      constructor(id:number, source: string,destination:string,arrivalTime: string,
        departureTime:string,totalSeat:number, baseFare:number,  busStatus:number,
        )
      {
        this.id=id;
        this.source= source;
        this.destination=destination;
        this.arrivalTime=arrivalTime;
        this.departureTime=departureTime;
        this.totalSeat=totalSeat;
        this.baseFare=baseFare;
        this.busStatus=busStatus;

      }

     
}