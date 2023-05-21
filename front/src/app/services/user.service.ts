import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UpdateUserRequest } from '../payload/request/updateUserRequest.interface';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private pathService = 'api/user';
  userId = this.sessionService.sessionInformation!.id;

  constructor(private httpClient: HttpClient, 
    private sessionService: SessionService) { }

  public updateUser(updateUserRequest: UpdateUserRequest): void {
    this.httpClient.put<void>(this.pathService + "/" + this.userId, updateUserRequest).subscribe();
  }

  public subscribe(themeId: number): void {
    this.httpClient.post<void>(this.pathService + "/" + this.userId + "/subscribe/" + themeId, {}).subscribe();
  }

  public unsubscribe(themeId: number): void {
    this.httpClient.post<void>(this.pathService + "/" + this.userId + "/unsubscribe/" + themeId, {}).subscribe();
  }


}
