import { Injectable } from '@angular/core';
import { Member } from '../common/member';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  baseUrl ="http://localhost:8989/member/";


  constructor(private httpClient: HttpClient) { }

  public getUser(searchUrl: string): Observable<Member> {
    return this.httpClient.get<Member>(searchUrl);
  }


  public getUserById(UserId:number):Observable<Member>{
    return this.httpClient.get<Member>(this.baseUrl + UserId);
  }

  //public deleteUserById(UserId:number):Observable
}
