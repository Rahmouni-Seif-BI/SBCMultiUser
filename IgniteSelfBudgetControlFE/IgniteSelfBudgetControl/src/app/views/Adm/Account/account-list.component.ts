import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { GridComponent } from '@syncfusion/ej2-angular-grids';
import { AccountControllerService } from 'libs/openapi/src';
import { loadCldr, setCulture, setCurrencyCode, L10n } from '@syncfusion/ej2-base';
import numbers from './../../../cldr-data/numbers.json';
import currencies from './../../../cldr-data/currencies.json';
import { extraConfig } from 'src/app/config/extraConfig';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit {



  constructor(private route: Router, private _service: AccountControllerService, public http: HttpClient) { }

  ngOnInit(): void {
    loadCldr( currencies,  numbers,  );
    setCulture('tr');
    setCurrencyCode('TND');
    this.load();
    
  }


  testCors() {
    this.http.get('http://localhost:8083/Account/getAllAccounts').subscribe((res:any)=> {
      if (res != null) {
        alert(res[0])
      }
      else{
        alert("BAD THING HAPPNED !!!!")
      }
    })
  }

  @ViewChild('grid') public grid!: GridComponent;

  load() {
    this._service.configuration.basePath= extraConfig.basePath;
    this._service.getAllAccounts().subscribe((data: any[]) => {
      this.grid.dataSource = data;
    });
  }


  delete() {
    this._service.configuration.basePath= extraConfig.basePath;
    if (this.grid.getSelectedRecords().length != 1) {
      alert('Sélectionner une ligne!');
    }
    else {
      let selectedrecord: any = this.grid.getSelectedRecords()[0]; // get the selected records.
      this._service.deleteAccount(selectedrecord['id']).subscribe((data: any) => {
        this.load()
      });
    }
  }


  public onDoubleClick(event: any): void {
    this.edit(event.rowData);
  }

  modify() {
    
    if (this.grid.getSelectedRecords().length != 1) {
      alert('Sélectionner une ligne!');
    }
    else {
      let selectedrecord: any = this.grid.getSelectedRecords()[0]; 
      this.edit(selectedrecord);
    }
  }



  public edit(selectedrecord: any) {

    const navigationExtras: NavigationExtras = {
      state: {
        id: selectedrecord.id,
      }
    };
    var routerPath = `/Adm/AccountForm`;
    this.route.navigateByUrl(routerPath, navigationExtras);
  }
}
