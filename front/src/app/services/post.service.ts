import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from '../interfaces/post.interface';
import { CreatePostRequest } from '../payload/request/createPostRequest.interface';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private pathService = 'api/post';
  userId = this.sessionService.sessionInformation!.id;

  constructor(private httpClient: HttpClient, 
    private sessionService: SessionService) { }

  public allSubscribed(): Observable<Post[]> {
    return this.httpClient.get<Post[]>("api/user/subscribedPosts/" + this.userId);
  }

  public createPost(request: CreatePostRequest): void{
    this.httpClient.post<void>(this.pathService, request).subscribe();
    console.log("create post done");
  }

  public getPostById(postId: number): Observable<Post> {
    return this.httpClient.get<Post>(`${this.pathService}/${postId}`);
  }
}
