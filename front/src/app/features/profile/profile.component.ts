import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ThemeService } from 'src/app/services/theme.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent  {
  public themes$ = this.themeService.all()

  constructor(private fb: FormBuilder,
    private router: Router, 
    private themeService: ThemeService) {}

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
    }  

}
