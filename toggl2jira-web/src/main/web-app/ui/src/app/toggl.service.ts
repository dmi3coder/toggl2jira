import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import {TogglTimer} from "./toggl-timer";
import {AsyncLocalStorage} from "angular-async-local-storage";
import {SettingsComponent} from "./settings/settings.component";

@Injectable()
export class TogglService {
  private togglUrl = 'http://localhost:8083/toggl';

  constructor(
    private http: HttpClient,
    protected localStorage: AsyncLocalStorage) {

  }


  getTogglTimers(): Observable<TogglTimer[]> {
    return Observable.create(observer => {
      this.localStorage.getItem('togglToken').subscribe(token => {
        console.log(token);
        const headerDict = {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
          'togglToken': token
        };

        const requestOptions = {
          headers: new HttpHeaders(headerDict),
        };
        this.http.get<TogglTimer[]>(this.togglUrl, requestOptions).subscribe(observer)
      });
    });
  }

}
