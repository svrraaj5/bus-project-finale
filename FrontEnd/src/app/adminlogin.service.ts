import { AdminLogin } from './login/AdminLogin';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminloginService {
  constructor(private http:HttpClient) { }

  getAdmins():Observable<AdminLogin[]>{
    return this.http.get<AdminLogin[]>("http://localhost:9091/UserApp/Admin/");
  }
}
