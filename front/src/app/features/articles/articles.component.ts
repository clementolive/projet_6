import { Component, OnInit } from '@angular/core';
import { Article } from 'src/app/interfaces/article.interface';
import { Router } from '@angular/router';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.scss']
})
export class ArticlesComponent implements OnInit {

  public art1: Article = {id:1, title:"New CSS tools",description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequa",
  createdAt: new Date(), theme_id:1};
  public art2: Article = {id:1, title:"New C++ tools",description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequa",
  createdAt: new Date(), theme_id:1};
  public art3: Article = {id:1, title:"New HTML tools",description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequa",
  createdAt: new Date(), theme_id:2};
  public articles = [this.art1, this.art2, this.art3];

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  goToDetail() {
    this.router.navigate(['detailArticle']);
  }
  
  //Sort articles by Date 
  sort(){}

}
