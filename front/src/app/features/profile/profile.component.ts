import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UpdateUserRequest } from 'src/app/payload/updateUserRequest.interface';
import { SessionService } from 'src/app/services/session.service';
import { ThemeService } from 'src/app/services/theme.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent  {
  public themes$ = this.themeService.all()

  constructor(private fb: FormBuilder,
    private router: Router, 
    private themeService: ThemeService, 
    private userService: UserService, 
    private sessionService: SessionService) {}

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

    submit() {
      const updateUserRequest = this.form.value as UpdateUserRequest;
    
      this.userService.updateUser(this.sessionService.sessionInformation!.id,
        updateUserRequest);

    }
}
