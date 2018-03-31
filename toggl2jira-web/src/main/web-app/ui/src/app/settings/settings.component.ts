import {Component, ElementRef, Injectable, OnInit, ViewChild} from '@angular/core';

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

  constructor() {
  }

  ngOnInit() {
    this.togglTokenInput.nativeElement.value = localStorage.getItem(TOGGL_TOKEN_KEY);
    this.jiraTokenInput.nativeElement.value  = localStorage.getItem(JIRA_TOKEN_KEY);
  }

  setTogglToken(event: any) {
    localStorage.setItem(TOGGL_TOKEN_KEY, event.target.value)
  }

  setJiraToken(event: any) {
    localStorage.setItem(JIRA_TOKEN_KEY, event.target.value)
  }

}
