import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ThemeService } from 'src/app/services/theme.service';
import { CreateArticleRequest } from '../../../payload/request/createArticleRequest.interface';
import { ArticleService } from 'src/app/services/article.service';

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.scss']
})
export class CreateArticleComponent implements OnInit{

  constructor(private fb: FormBuilder,
              private router: Router, 
              private themeService: ThemeService, 
              private articleService: ArticleService) {
  }
  ngOnInit(): void {
    
  }

  selectedTheme!: string;

  public themes$ = this.themeService.all();

  public form = this.fb.group({
   theme: [
      '',
      [
        Validators.required,
      ]
    ],
    title: [
      '',
      [
        Validators.required,
      ]
    ],
    content: [
      '',
      [
        Validators.required,
      ]
    ]
  });

  onSelected(value:string): void {
		this.selectedTheme = value;
	}


  public submit(): void{
    const createArticleRequest = this.form.value as CreateArticleRequest;
    this.articleService.createArticle(createArticleRequest);
    this.router.navigate(['articles']);
  }

}
