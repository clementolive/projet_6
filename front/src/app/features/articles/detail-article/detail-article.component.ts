import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Article } from 'src/app/interfaces/article.interface';
import { CreateCommentRequest } from 'src/app/payload/createCommentRequest.interface';
import { ArticleService } from 'src/app/services/article.service';
import { CommentService } from 'src/app/services/comment.service';

@Component({
  selector: 'app-detail-article',
  templateUrl: './detail-article.component.html',
  styleUrls: ['./detail-article.component.scss']
})
export class DetailArticleComponent {
  
  constructor(private route: ActivatedRoute, 
              private articleService: ArticleService,
              private commentService: CommentService,
              private fb: FormBuilder,
              private router: Router) { }

  articleId = this.route.snapshot.params['id'];
  article$ = this.articleService.getArticleById(this.articleId);

  public form = this.fb.group({
    content: [
      '',
      [
        Validators.required
      ]
    ]
  });

  public back(): void {
    window.history.back();
  }

  public submit(): void{
    const createCommentRequest = this.form.value as CreateCommentRequest;
    this.commentService.postComment(this.articleId, createCommentRequest);
  }

}
