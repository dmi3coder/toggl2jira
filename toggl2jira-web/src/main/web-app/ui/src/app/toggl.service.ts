import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import {TogglTimer} from "./toggl-timer";

@Injectable()
export class TogglService {
  private togglUrl = 'http://localhost:8083/toggl';
  private summaryUrl = 'http://localhost:8083/summary';

  constructor(private http: HttpClient) {

  }


  getTogglTimers(): Observable<TogglTimer[]> {
    let togglToken = localStorage.getItem('togglToken');
    console.log(togglToken);
    const headerDict = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'togglToken': togglToken
    };

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return this.http.get<TogglTimer[]>(this.togglUrl, requestOptions)
  }

  getSummary(): Observable<object[]> {
    let togglToken = localStorage.getItem('togglToken');
    let jiraToken = localStorage.getItem('jiraToken');
    const headerDict = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'togglToken': togglToken,
      'jiraToken': jiraToken,
      'jiraMail': 'dchaban@s-pro.io'
    };
    console.log('jiraToken', jiraToken);
    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return this.http.get<TogglTimer[]>(this.summaryUrl, requestOptions)
  }

}
