import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CreateCommentRequest } from '../payload/request/createCommentRequest.interface';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private pathService = 'api/post';

  constructor(private httpClient: HttpClient) { }

  public postComment(postId: number, request: CreateCommentRequest): any{
    return this.httpClient.post<void>(this.pathService + "/" + postId, request);
  }
}
