import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Theme } from '../interfaces/theme.interface';
import { ThemesResponse } from '../interfaces/themesResponse.interface';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  private pathService = 'api/themes';

  constructor(private httpClient: HttpClient) { }

  public all(): Observable<Theme[]> {
    return this.httpClient.get<Theme[]>(this.pathService);
  }
}
