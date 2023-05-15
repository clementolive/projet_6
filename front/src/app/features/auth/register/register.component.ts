import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  constructor(private fb: FormBuilder,
    private router: Router) { }

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

    submit() {
      this.router.navigate(['articles'])
    }  

}
