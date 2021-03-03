import { Injectable } from '@angular/core';
import { Member } from '../common/member';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  memberId!:number;
  model!:Member;

  constructor() { }

  setModel(data:number){
    this.memberId = data;
  }

  getModel(){
    return this.memberId;
  }

}
