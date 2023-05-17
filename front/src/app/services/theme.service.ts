import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Theme } from '../interfaces/theme.interface';
import { ThemesResponse } from '../payload/themesResponse.interface';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  private pathService = 'api/theme';

  constructor(private httpClient: HttpClient) { }

  public all(): Observable<Theme[]> {
    return this.httpClient.get<Theme[]>(this.pathService);
  }
}
