import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UpdateUserRequest } from 'src/app/payload/request/updateUserRequest.interface';
import { SessionService } from 'src/app/services/session.service';
import { TopicService } from 'src/app/services/topic.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent  {
  public topics$ = this.topicService.subscribedTopics();

  constructor(private fb: FormBuilder,
    private router: Router, 
    private topicService: TopicService, 
    private userService: UserService) {}

    public form = this.fb.group({
      username: [
        '',
        [
          Validators.required,
          
        ]
      ],
      email: [
        '',
        [
          Validators.required,
          Validators.email
        ]
      ]
    });

    reloadCurrentRoute() {
      let currentUrl = this.router.url;
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
          this.router.navigate([currentUrl]);
      });
    }

    submit() {
      const updateUserRequest = this.form.value as UpdateUserRequest;
      this.userService.updateUser(updateUserRequest);
    }

    unsubscribe(topicId:number){
        this.userService.unsubscribe(topicId);
        this.reloadCurrentRoute();
    }
}
