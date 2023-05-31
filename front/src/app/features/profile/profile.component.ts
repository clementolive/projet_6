import { Component, OnDestroy } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { UpdateUserRequest } from 'src/app/payload/request/updateUserRequest.interface';
import { TopicService } from 'src/app/services/topic.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnDestroy{
  public topics$ = this.topicService.subscribedTopics();
  public topicSubscription!: Subscription;
  updateSubscription!: Subscription;

  constructor(private fb: FormBuilder,
    private topicService: TopicService, 
    private userService: UserService) {}

    public form = this.fb.group({
      username: [
        '', [Validators.required]],
      email: [
        '',[
          Validators.required,
          Validators.email
        ]]
    });

    submit() {
      const updateUserRequest = this.form.value as UpdateUserRequest;
      this.updateSubscription = this.userService.updateUser(updateUserRequest).subscribe();
    }

    unsubscribe(topicId:number){
        this.topicSubscription = this.userService.unsubscribeToATopic(topicId).subscribe({
          next: () =>{
            this.topics$ = this.topicService.subscribedTopics();
          }
        });
    }

    ngOnDestroy(): void {
      if(this.topicSubscription) this.topicSubscription.unsubscribe();
      if(this.updateSubscription) this.updateSubscription.unsubscribe();
    }
}
