import { Component, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { TopicService } from 'src/app/services/topic.service';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-topics',
  templateUrl: './topics.component.html',
  styleUrls: ['./topics.component.scss']
})
export class TopicsComponent implements OnDestroy {
  public topics$ = this.topicService.all();
  public topicSubscription!: Subscription;

  constructor(private topicService: TopicService,
              private userService: UserService){}

  subscribe(topicId:number){
    this.topicSubscription = this.userService.subscribeToATopic(topicId).subscribe({
      next: () =>{
        this.topics$ = this.topicService.all();
      }
    });
  }

  ngOnDestroy(): void {
    if(this.topicSubscription)this.topicSubscription.unsubscribe();
  }

}
