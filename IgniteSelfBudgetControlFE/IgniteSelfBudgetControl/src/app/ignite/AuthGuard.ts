import { Injectable } from '@angular/core';
import { CanActivateChild, Router } from '@angular/router';
import { extraConfig } from './../config/extraConfig';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivateChild {
  constructor(private router: Router) {}
  userName = "";
  isLoading = false;

  canActivateChild(): boolean {
    if (this.isLogedIn()) {
      return true; // User is authenticated, allow access
    } else {
      this.router.navigate(['/login']); // Redirect to login if not authenticated
      return false;
    }
  }

  isLogedIn(): boolean {
    if (localStorage.getItem('AETB43s2346é(qfdgLDJSKNZREGèMVQ685FAEZRHbzdqvlkn')) {
      // this.userName = ' : Session ouverte pour ' + localStorage.getItem('user')
      return true
    }
    return false
  } 
}
