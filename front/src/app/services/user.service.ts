import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UpdateUserRequest } from '../payload/request/updateUserRequest.interface';
import { SessionService } from './session.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private pathService = 'api/user';

  constructor(private httpClient: HttpClient, 
    private sessionService: SessionService) { }

  public updateUser(updateUserRequest: UpdateUserRequest): any {
    let userId = this.sessionService.sessionInformation?.id;
    this.httpClient.put<any>(this.pathService + "/" + userId, updateUserRequest);
  }

  public subscribeToATopic(topicId: number): any {
    let userId = this.sessionService.sessionInformation?.id;
    return this.httpClient.post<any>(this.pathService + "/" + userId + "/subscribe/" + topicId, {});
  }

  public unsubscribeToATopic(topicId: number): any {
    let userId = this.sessionService.sessionInformation?.id;
    return this.httpClient.delete<Observable<any>>(this.pathService + "/" + userId + "/unsubscribe/" + topicId, {});
  }


}
