import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Member } from '../common/member';
import { Post } from '../common/post';
import { LoginServiceService } from '../service/login-service.service';
import { PostService } from '../service/Post.service';
import { SharedService } from '../service/shared.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  post!:Post;

  memberId!:number;
  member!:Member;
  filtersLoaded: Promise<boolean>=Promise.resolve(false);

  postFormGroup!:FormGroup;

  constructor(private formBuilder:FormBuilder,private shared:SharedService, private loginService:LoginServiceService,private postService:PostService) {
   this.post = new Post();
   }

  

  ngOnInit(): void {

    this.postFormGroup = this.formBuilder.group({
     
      title: new FormControl('',Validators.required),
      description: new FormControl('',Validators.required),
      imgUrl: new FormControl('',Validators.required),
    

}
  ) 
    // login sayfasından girilen kullanıcıyı al ve ata
    this.memberId = this.shared.getModel()
    this.loginService.getUserById(this.memberId).subscribe(
      data =>{
        this.member = data; 
        console.log(this.member.posts);
        this.filtersLoaded = Promise.resolve(true);
      } 
    )
   
  }


  onSubmit(){
    console.log(this.postFormGroup);
    //değerleri posta ata yolla
    this.post.title = this.postFormGroup.value.title;
    this.post.imgUrl = this.postFormGroup.value.imageUrl;
    this.post.description = this.postFormGroup.value.description;
    this.post.member =this.member;
    this.postService.postContent(this.post).subscribe(data => {
      console.log(data)
    }) 
    //yenile
    this.ngOnInit();

    console.log(this.post);
  }

  deleteById(id:number){
    console.log(id);
    this.postService.deletePost(id.toString()).subscribe(
      data=> console.log(data)
    );
    this.ngOnInit();
  }

}
