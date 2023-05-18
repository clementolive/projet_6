import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Article } from 'src/app/interfaces/article.interface';
import { ArticleService } from 'src/app/services/article.service';

@Component({
  selector: 'app-detail-article',
  templateUrl: './detail-article.component.html',
  styleUrls: ['./detail-article.component.scss']
})
export class DetailArticleComponent implements OnInit {
  article$!: Observable<Article>;

  constructor(private route: ActivatedRoute, 
    private articleService: ArticleService) { }

  ngOnInit(): void {
    const articleId = this.route.snapshot.params['id'];
    this.article$ = this.articleService.getArticleById(articleId);
  }

  public back(): void {
    window.history.back();
  }

}
