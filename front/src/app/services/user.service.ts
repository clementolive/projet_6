import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UpdateUserRequest } from '../payload/request/updateUserRequest.interface';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private pathService = 'api/user';

  constructor(private httpClient: HttpClient, 
    private sessionService: SessionService) { }

  public updateUser(updateUserRequest: UpdateUserRequest): void {
    let userId = this.sessionService.sessionInformation?.id;
    this.httpClient.put<void>(this.pathService + "/" + userId, updateUserRequest).subscribe();
  }

  public subscribe(topicId: number): void {
    let userId = this.sessionService.sessionInformation?.id;
    this.httpClient.post<void>(this.pathService + "/" + userId + "/subscribe/" + topicId, {}).subscribe();
  }

  public unsubscribe(topicId: number): void {
    let userId = this.sessionService.sessionInformation?.id;
    this.httpClient.delete<void>(this.pathService + "/" + userId + "/unsubscribe/" + topicId, {}).subscribe();
  }


}
