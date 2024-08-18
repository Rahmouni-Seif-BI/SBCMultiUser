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

    this.userService.loginUserEntity(data.login, data.password).subscribe( (res: any)=> {
      if(res != null)
        {
          localStorage.setItem("user", res.login)
          localStorage.setItem('authtoken', res.authtoken);
          this.router.navigate(['/Adm/AccountList']);
  
        }
    })
  }

  
  // getUserFormData(data: any){
  //   this.isLoading = true;
  //   this.userService.configuration.basePath = extraConfig.basePath;
  //   this.userService.apiUserLoginPost(data.login, data.password, 'WEBAPP').subscribe((result: any) => {
  //     localStorage.setItem('userId', result.pKey);
  //     localStorage.setItem('code', result.code);
  //     localStorage.setItem('user', result.description);
  //     localStorage.setItem('email', result.email);
  //     localStorage.setItem('mobile', result.mobile);
  //     localStorage.setItem('cfgEmployeeId', result.cfgEmployeeId);
  //     localStorage.setItem('cfgEmployeeCode', result.cfgEmployeeCode);
  //     localStorage.setItem('cfgEmployeeDescription', result.cfgEmployeeDescription);
  //     localStorage.setItem('webRoleDescription', result.webRoleDescription);
  //     localStorage.setItem('authtoken', result.authtoken);
  //     //Culture data
  //     localStorage.setItem('cultureCode', result.cultureCode);
  //     localStorage.setItem('dateExtjsShortFormat', result.dateExtjsShortFormat);
  //     localStorage.setItem('dateExtjsLongFormat', result.dateExtjsLongFormat);
  //     localStorage.setItem('dateExtjsAltFormat', result.dateExtjsAltFormat);
  //     localStorage.setItem('dateShortFormat', result.dateShortFormat);
  //     localStorage.setItem('dateLongFormat', result.dateLongFormat);
  //     localStorage.setItem('dateSeparator', result.dateSeparator);
  //     localStorage.setItem('numberNegativeFormat', result.numberNegativeFormat);
  //     localStorage.setItem('numberGrouping', result.numberGrouping);
  //     localStorage.setItem('numberDecimalCount', result.numberDecimalCount);
  //     localStorage.setItem('numberGroupingSymbol', result.numberGroupingSymbol);
  //     localStorage.setItem('numberDecimalSymbol', result.numberDecimalSymbol);
  //     localStorage.setItem('numberNegativeSymbol', result.numberNegativeSymbol);
  //     localStorage.setItem('numberPosifiveSymbol', result.numberPosifiveSymbol);
  //     localStorage.setItem('percentageNegativeFormat', result.percentageNegativeFormat);
  //     localStorage.setItem('percentagePositiveFormat', result.percentagePositiveFormat);
  //     localStorage.setItem('percentageGroupingNumber', result.percentageGroupingNumber);
  //     localStorage.setItem('percentageNumberofDecimal', result.percentageNumberofDecimal);
  //     localStorage.setItem('percentageSymbol', result.percentageSymbol);
  //     localStorage.setItem('percentageNumberGroupingSymbol', result.percentageNumberGroupingSymbol);
  //     localStorage.setItem('percentageDecimalSymbol', result.percentageDecimalSymbol);
  //     localStorage.setItem('percentageThousandSymbol', result.percentageThousandSymbol);
  //     localStorage.setItem('timeExtjsFormat', result.timeExtjsFormat);
  //     localStorage.setItem('timeShortFormat', result.timeShortFormat);
  //     localStorage.setItem('timeLongFormat', result.timeLongFormat);
  //     localStorage.setItem('timeSeparator', result.timeSeparator);
  //     localStorage.setItem('timeMorningSymbol', result.timeMorningSymbol);
  //     localStorage.setItem('timeEveningSymbol', result.timeEveningSymbol);
  //     localStorage.setItem('deviceNegativeFormat', result.deviceNegativeFormat);
  //     localStorage.setItem('devicePositiveFormat', result.devicePositiveFormat);
  //     localStorage.setItem('deviseGrouping', result.deviseGrouping);
  //     localStorage.setItem('deviseDecimalCount', result.deviseDecimalCount);
  //     localStorage.setItem('deviseGroupingSymbol', result.deviseGroupingSymbol);
  //     localStorage.setItem('deviseDecimalSymbol', result.deviseDecimalSymbol);
  //     this.router.navigate(['/dashboard']);    }
  //     , () => {
  //       this.isLoading = false;
  //     }
  //   );
  // }




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
