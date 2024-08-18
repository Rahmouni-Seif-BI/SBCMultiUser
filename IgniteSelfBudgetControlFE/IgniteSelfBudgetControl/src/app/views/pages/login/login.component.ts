import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { extraConfig } from 'src/app/config/extraConfig';
import { UserEntityControllerService } from 'libs/openapi/src';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  constructor( private router: Router, private userService: UserEntityControllerService) { }
  isLoading = false;
  
  loginForm = new FormGroup({
    login: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
  })

  get login() {
    return this.loginForm.get('login')
  }

  get password() {
    return this.loginForm.get('password')
  }
  
  getUserFormData(data: any)
  {

    this.userService.loginUserEntity(data.login, data.password).subscribe( (res => {
      if(res != null)
        {
          localStorage.setItem("AETB43s2346é(qfdgLDJSKNZREGèMVQ685FAEZRHbzdqvlkn", "gg")
          this.router.navigate(['/dashboard']);
  
        }
    }))
  }



  ResetPassword(data: any) {
    // this.userService.configuration.basePath = extraConfig.basePath;
    // this.userService.apiUserResetPasswordPost(data.email).subscribe((result: any) => {
    //   this.YesMessageComponent.messageSuccess(result);
    //   // this.router.navigate(['/ResetPasswordLink'])
    // });
  }

  resetForm = new FormGroup({
    email: new FormControl('', [Validators.required]),
  })

  showLogin = true;
  buttonLabel = "Mot de passe oublié ?"
  redirectToForgetPassword() {
    this.showLogin = !this.showLogin;
    if (!this.showLogin) {
      this.buttonLabel = "Annuler"
    }
    else
      this.buttonLabel = "Mot de passe oublié ?"
  }

  get email() {
    return this.resetForm.get('email')
  }
}
