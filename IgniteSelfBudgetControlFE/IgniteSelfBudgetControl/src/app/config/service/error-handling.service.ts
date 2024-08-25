import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})

export class ErrorHandlingService {
  constructor(private router: Router){}
  handleError(exception: any): void {
    if (exception.status = 403) {
        localStorage.setItem('authtoken', '');
        localStorage.setItem('user', '');
        this.router.navigateByUrl('/login');
    }
  }
}