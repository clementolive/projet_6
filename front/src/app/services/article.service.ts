import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Theme } from '../interfaces/theme.interface';
import { Article } from '../interfaces/article.interface';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  private pathService = 'api/article';

  constructor(private httpClient: HttpClient) { }

  public all(): Observable<Article[]> {
    return this.httpClient.get<Article[]>(this.pathService);
  }
}
