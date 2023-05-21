import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CreateCommentRequest } from 'src/app/payload/request/createCommentRequest.interface';
import { PostService } from 'src/app/services/post.service';
import { CommentService } from 'src/app/services/comment.service';
@Component({
  selector: 'app-detail-post',
  templateUrl: './detail-post.component.html',
  styleUrls: ['./detail-post.component.scss']
})
export class DetailPostComponent {
  
  constructor(private route: ActivatedRoute, 
              private postService: PostService,
              private commentService: CommentService,
              private fb: FormBuilder,
              private router: Router) { }

  postId = this.route.snapshot.params['id'];
  post$ = this.postService.getPostById(this.postId);

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

  reloadCurrentRoute() {
    let currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.router.navigate([currentUrl]);
    });
}

  public submit(): void{
    const createCommentRequest = this.form.value as CreateCommentRequest;
    this.commentService.postComment(this.postId, createCommentRequest);
    this.reloadCurrentRoute();
  }

}
