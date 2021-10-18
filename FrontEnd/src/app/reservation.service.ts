import { Bus } from './admin/Bus';
import { Reservation } from './payment/Reservation';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http:HttpClient) { }

  getReservation(){
    return this.http.get<Reservation[]>("http://localhost:9091/UserApp/Reserve/");
  }

  getReservationBytno(id:number){
    return this.http.get<Reservation>("http://localhost:9091/UserApp/Reserve/"+id);
  }

  getReservationByEmailId(emailId:string){
    return this.http.get<Reservation[]>("http://localhost:9091/UserApp/Reserve/res/"+emailId);
  }

  addReservation(res:Reservation){
    return this.http.post("http://localhost:9091/UserApp/Reserve/",res);
  }

  cancelReservation(tNo:number){
    return this.http.delete("http://localhost:9091/UserApp/Bus/"  + tNo);
  }

  setBus(res:Reservation, bus:Bus){
    return this.http.put("http://localhost:9091/UserApp/Reserve/set",{res, bus})
  }

  updateReservation(res:Reservation){
    return this.http.put("http://localhost:9091/UserApp/Reserve/", res);
  }

  deleteReservation(tno:number){
    return this.http.delete("http://localhost:9091/UserApp/Reserve/"+tno);
  }

}
