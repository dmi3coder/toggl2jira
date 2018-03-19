import {Component, ElementRef, Injectable, OnInit, ViewChild} from '@angular/core';
import {logger} from "codelyzer/util/logger";
import {AsyncLocalStorage} from "angular-async-local-storage";

const TOGGL_TOKEN_KEY: string = "togglToken";
const JIRA_TOKEN_KEY: string = "jiraToken";

@Injectable()
@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {
  @ViewChild('togglTokenInput') togglTokenInput: ElementRef;
  @ViewChild('jiraTokenInput') jiraTokenInput: ElementRef;

  constructor(protected localStorage: AsyncLocalStorage) {
  }

  ngOnInit() {
    this.localStorage.getItem(TOGGL_TOKEN_KEY).subscribe((tokenValue) => {
      this.togglTokenInput.nativeElement.value = tokenValue;
    });
    this.localStorage.getItem(JIRA_TOKEN_KEY).subscribe((tokenValue) => {
      this.jiraTokenInput.nativeElement.value = tokenValue;
    });
  }

  setTogglToken(event: any) {
    this.localStorage.setItem(TOGGL_TOKEN_KEY, event.target.value).subscribe(() => {});
  }

  setJiraToken(event: any) {
    this.localStorage.setItem(JIRA_TOKEN_KEY, event.target.value).subscribe(() => {});
  }

}
