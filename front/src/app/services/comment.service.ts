import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CreateCommentRequest } from '../payload/createCommentRequest.interface';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private pathService = 'api/article';

  constructor(private httpClient: HttpClient) { }

  public postComment(articleId: number, request: CreateCommentRequest): void{
    this.httpClient.post<void>(this.pathService + "/" + articleId, request).subscribe();
    console.log("create comment request sent (frontend)");
  }
}
