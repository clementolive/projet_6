import { Component, OnDestroy } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute} from '@angular/router';
import { CreateCommentRequest } from 'src/app/payload/request/createCommentRequest.interface';
import { PostService } from 'src/app/services/post.service';
import { CommentService } from 'src/app/services/comment.service';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-detail-post',
  templateUrl: './detail-post.component.html',
  styleUrls: ['./detail-post.component.scss']
})
export class DetailPostComponent implements OnDestroy{
  
  constructor(private route: ActivatedRoute, 
              private postService: PostService,
              private commentService: CommentService,
              private fb: FormBuilder) { }

  postId = this.route.snapshot.params['id'];
  post$ = this.postService.getPostById(this.postId);
  commentSubscription!: Subscription;

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
    this.commentSubscription = this.commentService.postComment(this.postId, createCommentRequest).subscribe({
      next: () =>{
        this.post$ = this.postService.getPostById(this.postId);
      }
    });
  }

  ngOnDestroy(): void {
    if(this.commentSubscription) this.commentSubscription.unsubscribe();
  }

}
