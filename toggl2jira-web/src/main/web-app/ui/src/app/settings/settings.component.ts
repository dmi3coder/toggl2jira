import {Component, ElementRef, Injectable, OnInit, ViewChild} from '@angular/core';
import {logger} from "codelyzer/util/logger";
import {AsyncLocalStorage} from "angular-async-local-storage";

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
    console.log(localStorage);
    this.localStorage.getItem('togglToken').subscribe((tokenValue) => {
      this.togglTokenInput.nativeElement.value = tokenValue;
    });
    this.localStorage.getItem('jiraToken').subscribe((tokenValue) => {
      this.jiraTokenInput.nativeElement.value = tokenValue;
    });

  }

  ngOnInit() {
  }

  setTogglToken(event: any) {
    this.localStorage.setItem('togglToken', event.target.value).subscribe(() => {});
  }

  setJiraToken(event: any) {
    this.localStorage.setItem('jiraToken', event.target.value).subscribe(() => {});
  }

}
