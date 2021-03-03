import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Member } from '../common/member';
import { LoginServiceService } from '../service/login-service.service';
import { SharedService } from '../service/shared.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  baseUrl:string = "http://localhost:8989/member/login";

  member!:Member;

  loginFormGroup!:FormGroup;

  constructor(private formBuilder:FormBuilder,
     private router: Router, private loginservice:LoginServiceService, private shared:SharedService) { }

  ngOnInit(): void {
    this.loginFormGroup = this.formBuilder.group({
     
        username: new FormControl('',Validators.required),
        password: new FormControl('',Validators.required),
      
  
  }
    ) 

}

onSubmit(){
  console.log(this.loginFormGroup);
  this.loginservice.getUser(this.baseUrl+"?username="+this.loginFormGroup.value.username+"&password="+this.loginFormGroup.value.password).subscribe(
    data =>{
      this.member = data;
      console.log(this.member);
      if(this.member != null){
        //send user's id to home page to retrieve by id
        this.shared.setModel(this.member.id);
        // navigate to home from routes in app module
        this.router.navigate(['/home']);
      }
    }
  );

}





}