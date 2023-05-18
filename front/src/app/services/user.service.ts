import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UpdateUserRequest } from '../payload/updateUserRequest.interface';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private pathService = 'api/user';

  constructor(private httpClient: HttpClient) { }

  public updateUser(userId: number, updateUserRequest: UpdateUserRequest): void {
    this.httpClient.put<void>(this.pathService + "/" + userId, updateUserRequest).subscribe();
  }
}
