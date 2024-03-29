import { Component, OnDestroy } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterRequest } from '../interfaces/registerRequest.interface';
import { AuthService } from '../services/auth.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnDestroy {
  public onError = false;
  public registerSubscription!: Subscription;

  constructor(private authService: AuthService,
              private fb: FormBuilder,
              private router: Router) {}

    public form = this.fb.group({
      email: [
        '',
        [
          Validators.required,
          Validators.email
        ]
      ],
      username: [
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
      const registerRequest = this.form.value as RegisterRequest;
      this.registerSubscription =  this.authService.register(registerRequest).subscribe({
          next: (_: void) => this.router.navigate(['/login']),
          error: _ => this.onError = true,
        }
      );
    }

    ngOnDestroy(): void {
      this.registerSubscription.unsubscribe();
    }

}
