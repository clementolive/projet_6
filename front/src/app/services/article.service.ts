import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Theme } from '../interfaces/theme.interface';
import { Article } from '../interfaces/article.interface';
import { CreateArticleRequest } from '../payload/request/createArticleRequest.interface';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  private pathService = 'api/article';
  userId = this.sessionService.sessionInformation!.id;

  constructor(private httpClient: HttpClient, 
    private sessionService: SessionService) { }

  public all_subscribed(): Observable<Article[]> {
    return this.httpClient.get<Article[]>("api/user/subscribedArticles/" + this.userId);
  }

  public createArticle(request: CreateArticleRequest): void{
    this.httpClient.post<void>(this.pathService, request).subscribe();
    console.log("post article done");
  }

  public getArticleById(articleId: number): Observable<Article> {
    return this.httpClient.get<Article>(`${this.pathService}/${articleId}`);
  }
}
