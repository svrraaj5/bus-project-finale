import { Observable } from 'rxjs';
import { UserLogin } from './login/UserLogin';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserloginService {

  constructor(private http:HttpClient) { }

  getUsers():Observable<UserLogin[]>{
    return this.http.get<UserLogin[]>("http://localhost:9091/UserApp/Users/");
  }

}
