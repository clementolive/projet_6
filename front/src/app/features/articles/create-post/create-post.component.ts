import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TopicService } from 'src/app/services/topic.service';
import { CreatePostRequest } from '../../../payload/request/createPostRequest.interface';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.scss']
})
export class CreatePostComponent{

  constructor(private fb: FormBuilder,
              private router: Router, 
              private topicService: TopicService, 
              private postService: PostService) {
  }

  selectedTopic!: string;
  public topics$ = this.topicService.all();

  public form = this.fb.group({
   topic: [
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
		this.selectedTopic = value;
	}

  public submit(): void{
    const createpostRequest = this.form.value as CreatePostRequest;
    this.postService.createPost(createpostRequest);
    this.router.navigate(['posts']);
  }

}
