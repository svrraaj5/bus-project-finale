import { Seat } from './seat-layout/Seat';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SeatService {

  constructor(private http:HttpClient) { }

  addSeat(seat:Seat){
    console.log("call add seat")
    return this.http.post("http://localhost:9091/UserApp/Seat/",seat);
  }

  updateSeat(seat:Seat){
    return this.http.put("http://localhost:9091/UserApp/Seat/",seat);
  }

  getSeat(){
    return this.http.get<Seat[]>("http://localhost:9091/UserApp/Seat/");
  }

  getSeatByIdDate(id:number, date:string){
    return this.http.get<number[]>("http://localhost:9091/UserApp/Seat/"+id+'/'+date);
  }

  deleteSeat(id:number){
    return this.http.delete("http://localhost:9091/UserApp/Seat/"+id);
  }
}
