import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Register } from './register/Register';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http:HttpClient) { }

  addRegistration(rgst:Register):Observable<Object>{
    return this.http.post("http://localhost:9091/UserApp/Users/",rgst);
  }

  getRegistration():Observable<Register[]>{
    return this.http.get<Register[]>("http://localhost:9091/UserApp/Users/");
  }

  getRegistrationById(id:string){
    return this.http.get<Register>("http://localhost:9091/UserApp/Users/"+id);
  }

  getOtp(email:string){
    return this.http.get<string>("http://localhost:9091/UserApp/Users/getOtp/"+email);
  }

  resetPassword(email:string, user:Register){
    return this.http.put("http://localhost:9091/UserApp/Users/"+email,user);
  }
}
