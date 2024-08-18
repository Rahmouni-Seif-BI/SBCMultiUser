import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { extraConfig } from 'src/app/config/extraConfig';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
})
export class LogoutComponent implements OnInit {
  constructor(private router: Router) {
  }


  ngOnInit(): void {
    if (!localStorage.getItem('user')) {
      this.router.navigate(['/login']);
    }
    else {
      localStorage.setItem('user', "")
      localStorage.setItem('authtoken', "")
      this.router.navigate(['/login']);
      }
  }
}
