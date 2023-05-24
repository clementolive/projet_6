import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/interfaces/post.interface';
import { Router } from '@angular/router';
import { PostService } from 'src/app/services/post.service';
import { Observable } from 'rxjs';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.scss']
})
export class FeedComponent {

  constructor(private router: Router, 
    private postService: PostService, 
    private sessionService: SessionService) { }

  public posts$: Observable<Post[]> = this.postService.allSubscribed();

  goToDetail(postId: number) {
    this.router.navigate(["detailPost", postId]);
  }
  
}
