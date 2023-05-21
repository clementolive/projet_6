import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CreateCommentRequest } from '../payload/request/createCommentRequest.interface';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private pathService = 'api/post';

  constructor(private httpClient: HttpClient) { }

  public postComment(postId: number, request: CreateCommentRequest): void{
    this.httpClient.post<void>(this.pathService + "/" + postId, request).subscribe();
    console.log("create comment request sent (frontend)");
  }
}
