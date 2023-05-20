import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UpdateUserRequest } from 'src/app/payload/request/updateUserRequest.interface';
import { SessionService } from 'src/app/services/session.service';
import { ThemeService } from 'src/app/services/theme.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent  {
  public themes$ = this.themeService.subscribed_themes();

  constructor(private fb: FormBuilder,
    private router: Router, 
    private themeService: ThemeService, 
    private userService: UserService) {}

    public form = this.fb.group({
      username: [
        '',
        [
          Validators.required,
          
        ]
      ],
      email: [
        '',
        [
          Validators.required,
          Validators.email
        ]
      ]
    });

    reloadCurrentRoute() {
      let currentUrl = this.router.url;
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
          this.router.navigate([currentUrl]);
      });
    }

    submit() {
      const updateUserRequest = this.form.value as UpdateUserRequest;
      this.userService.updateUser(updateUserRequest);
    }

    unsubscribe(themeId:number){
        this.userService.unsubscribe(themeId);
        this.reloadCurrentRoute();
    }
}
