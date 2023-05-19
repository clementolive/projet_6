import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private pathService = 'api/article';

  constructor(private httpClient: HttpClient) { }
}
