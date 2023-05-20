import { Component, OnInit } from '@angular/core';
import { Article } from 'src/app/interfaces/article.interface';
import { Router } from '@angular/router';
import { ArticleService } from 'src/app/services/article.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.scss']
})
export class ArticlesComponent {

  constructor(private router: Router, 
    private articleService: ArticleService) { }

  public articles$: Observable<Article[]> = this.articleService.all_subscribed();

  goToDetail(articleId: number) {
    //this.router.navigate(['detailArticle/${articleId}']);
    this.router.navigate(["detailArticle", articleId]);
  }
  
  //Sort articles by Date 
  sort(){

  }

}
