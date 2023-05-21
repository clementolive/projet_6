import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Topic } from '../interfaces/topic.interface';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'root'
})
export class TopicService {
  private pathService = 'api/topic';

  constructor(private httpClient: HttpClient, 
    private sessionService: SessionService) { }

  public all(): Observable<Topic[]> {
    return this.httpClient.get<Topic[]>(this.pathService);
  }

  public subscribedTopics():  Observable<Topic[]> {
    let user_id = this.sessionService.sessionInformation!.id;
    return this.httpClient.get<Topic[]>("api/user/" + user_id + "/subscriptions");
  }
}
