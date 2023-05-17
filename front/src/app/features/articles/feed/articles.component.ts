import { Component, OnInit } from '@angular/core';
import { Article } from 'src/app/interfaces/article.interface';
import { Router } from '@angular/router';
import { ArticleService } from 'src/app/services/article.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.scss']
})
export class ArticlesComponent {

  constructor(private router: Router, 
    private articleService: ArticleService) { }

  public articles$ = this.articleService.all();


  goToDetail() {
    this.router.navigate(['detailArticle']);
  }
  
  //Sort articles by Date 
  sort(){}

}
