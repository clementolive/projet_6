import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from '../interfaces/post.interface';
import { CreatePostRequest } from '../payload/request/createPostRequest.interface';
import { SessionService } from './session.service';
import { MessageResponse } from '../payload/reponse/MessageResponse.interface';
import { Subscription } from 'cypress/types/net-stubbing';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private pathService = 'api/post';

  constructor(private httpClient: HttpClient, 
    private sessionService: SessionService) { }

  public allSubscribed(): Observable<Post[]> {
    let userId = this.sessionService.sessionInformation?.id;
    return this.httpClient.get<Post[]>("api/user/subscribedPosts/" + userId);
  }

  public createPost(request: CreatePostRequest): Observable<MessageResponse>{
    return this.httpClient.post<MessageResponse>(this.pathService, request);
  }

  public getPostById(postId: number): Observable<Post> {
    return this.httpClient.get<Post>(`${this.pathService}/${postId}`);
  }
}
