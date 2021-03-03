import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Post } from '../common/post';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  baseUrl ="http://localhost:8989/post/";
constructor(private httpClient: HttpClient) { }
public postContent(post: Post) {
  return this.httpClient.post<any>(this.baseUrl +"create/" ,post);
}

public deletePost(id:string){
  return this.httpClient.delete(this.baseUrl+"delete/"+ id);
}
}
