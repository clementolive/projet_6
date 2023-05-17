import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SessionService } from 'src/app/services/session.service';
import { LoginRequest } from '../interfaces/loginRequest.interface';
import { SessionInformation } from '../interfaces/sessionInformation.interface';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  public onError = false;
  constructor(private authService: AuthService,
    private fb: FormBuilder,
    private router: Router,
    private sessionService: SessionService) {
  }

  public form = this.fb.group({
    email: [
      '',
      [
        Validators.required,
        
      ]
    ],
    password: [
      '',
      [
        Validators.required,
        Validators.minLength(8),
        // At least one Uppercase, special character, and a number 
        Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}')
      ]
    ]
  });

  public submit(): void {
    const loginRequest = this.form.value as LoginRequest;
    this.authService.login(loginRequest).subscribe({
      next: (response: SessionInformation) => {
        this.sessionService.logIn(response);
        this.router.navigate(['/articles']);
      },
      error: error => this.onError = true,
    });
  }

}
