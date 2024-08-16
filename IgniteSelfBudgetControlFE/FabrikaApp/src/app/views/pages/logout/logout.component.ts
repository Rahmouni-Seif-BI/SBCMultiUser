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
    if (!localStorage.getItem('AETB43s2346é(qfdgLDJSKNZREGèMVQ685FAEZRHbzdqvlkn')) {
      this.router.navigate(['/login']);
    }
    else {
      localStorage.setItem('AETB43s2346é(qfdgLDJSKNZREGèMVQ685FAEZRHbzdqvlkn', "")
      this.router.navigate(['/login']);
      }
  }
}
