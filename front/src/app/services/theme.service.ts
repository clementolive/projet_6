import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Theme } from '../interfaces/theme.interface';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  private pathService = 'api/theme';

  constructor(private httpClient: HttpClient, 
    private sessionService: SessionService) { }

  public all(): Observable<Theme[]> {
    return this.httpClient.get<Theme[]>(this.pathService);
  }

  public subscribed_themes():  Observable<Theme[]> {
    let user_id = this.sessionService.sessionInformation!.id;
    return this.httpClient.get<Theme[]>("api/user/" + user_id + "/subscriptions");
  }
}
