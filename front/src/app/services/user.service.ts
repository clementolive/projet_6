import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UpdateUserRequest } from '../payload/request/updateUserRequest.interface';
import { SessionService } from './session.service';
import { Observable } from 'rxjs';
import { MessageResponse } from '../payload/response/messageResponse.interface';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private pathService = 'api/user';

  constructor(private httpClient: HttpClient, 
    private sessionService: SessionService) { }

  public updateUser(updateUserRequest: UpdateUserRequest):void {
    let userId = this.sessionService.sessionInformation?.id;
    this.httpClient.put<MessageResponse>(this.pathService + "/" + userId, updateUserRequest);
  }

  public subscribeToATopic(topicId: number): Observable<MessageResponse> {
    let userId = this.sessionService.sessionInformation?.id;
    return this.httpClient.post<MessageResponse>(this.pathService + "/" + userId + "/subscribe/" + topicId, {});
  }

  public unsubscribeToATopic(topicId: number): Observable<MessageResponse> {
    let userId = this.sessionService.sessionInformation?.id;
    return this.httpClient.delete<MessageResponse>(this.pathService + "/" + userId + "/unsubscribe/" + topicId, {});
  }


}
