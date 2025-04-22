import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../common/user';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  private baseUrl = "http://localhost:8080/";

  constructor(private httpclient:HttpClient) { }


  getUserData(id:number):Observable<User>{

    const userUrl = `${this.baseUrl}/users/${id}`
    return this.httpclient.get<User>(userUrl);
  }
}


