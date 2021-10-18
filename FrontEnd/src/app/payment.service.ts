import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Payment } from './seat-layout/Payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http:HttpClient) { }

  addPay(pay:Payment){
    return this.http.post("http://localhost:9091/UserApp/Pay/", pay);
  }

  delPay(pid:number){
    return this.http.delete("http://localhost:9091/UserApp/Pay/"+pid);
  }
}
