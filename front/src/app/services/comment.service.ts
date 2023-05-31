import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CreateCommentRequest } from '../payload/request/createCommentRequest.interface';
import { MessageResponse } from '../payload/response/messageResponse.interface';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private pathService = 'api/post';

  constructor(private httpClient: HttpClient) { }

  public postComment(postId: number, request: CreateCommentRequest): Observable<MessageResponse>{
    return this.httpClient.post<MessageResponse>(this.pathService + "/" + postId, request);
  }
}
