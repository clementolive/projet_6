import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Theme } from 'src/app/interfaces/theme.interface';
import { ThemesResponse } from 'src/app/interfaces/themesResponse.interface';
import { ThemeService } from 'src/app/services/theme.service';

@Component({
  selector: 'app-themes',
  templateUrl: './themes.component.html',
  styleUrls: ['./themes.component.scss']
})
export class ThemesComponent{
  public themes$ = this.themeService.all();


  constructor(private themeService: ThemeService){}




}
