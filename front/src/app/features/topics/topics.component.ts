import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from 'src/app/services/session.service';
import { TopicService } from 'src/app/services/topic.service';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-topics',
  templateUrl: './topics.component.html',
  styleUrls: ['./topics.component.scss']
})
export class TopicsComponent{
  public topics$ = this.topicService.all();

  constructor(private topicService: TopicService,
              private router: Router, 
              private userService: UserService, 
              private sessionService: SessionService){}

  subscribe(topicId:number){
      this.userService.subscribeToATopic(topicId).subscribe({
        next: () =>{
          this.topics$ = this.topicService.all();
        }
      });
  }

}
