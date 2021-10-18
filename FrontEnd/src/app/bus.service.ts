
import { Bus } from './admin/Bus';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BusService {

  constructor(private http:HttpClient) { }

  getbus(){
    return this.http.get<Bus[]>("http://localhost:9091/UserApp/Bus/");
  }
  addbus(bus:Bus){
    return this.http.post("http://localhost:9091/UserApp/Bus/", bus);
  }

  updateBus(bus:Bus) {
    return this.http.put("http://localhost:9091/UserApp/Bus/", bus);
  }

  updateBusByIdDateSeat(id:number, date:string, seat:number, bus:Bus) {
    return this.http.put("http://localhost:9091/UserApp/Bus/"+id+'/'+ date+'/' + seat, bus);
  }

  deleteBus(id: number, date:string) {
    return this.http.delete("http://localhost:9091/UserApp/Bus/"  + id + '/' + date);
  }

  removeBus(bus:Bus,id:number, date:string){
    return this.http.put("http://localhost:9091/UserApp/Bus/"+'/'+id, bus);
  }
  
  getbusbyFromTo(from: string, to: string){
    return this.http.get<Bus[]>("http://localhost:9091/UserApp/Bus/" + from+'/'+to);
  }

  getbusbyFromToDateCB(from: string, to: string, dt: string, cb:number){
    return this.http.get<Bus[]>("http://localhost:9091/UserApp/Bus/" + from+'/'+to+'/'+dt+'/'+cb);
  }

  getBusById(id:number){
    return this.http.get<Bus>("http://localhost:9091/UserApp/Bus/" + id );
  }
}
