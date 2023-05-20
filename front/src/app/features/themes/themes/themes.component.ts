import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { Theme } from 'src/app/interfaces/theme.interface';
import { ThemesResponse } from 'src/app/payload/themesResponse.interface';
import { ThemeService } from 'src/app/services/theme.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-themes',
  templateUrl: './themes.component.html',
  styleUrls: ['./themes.component.scss']
})
export class ThemesComponent{
  public themes$ = this.themeService.all();


  constructor(private themeService: ThemeService,
              private router: Router, 
              private userService: UserService){}

  reloadCurrentRoute() {
    let currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.router.navigate([currentUrl]);
    });
  }

  subscribe(theme_id:number){
      this.userService.subscribe(theme_id);
      this.reloadCurrentRoute();
  }




}
