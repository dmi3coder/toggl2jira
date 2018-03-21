import { Component, OnInit } from '@angular/core';
import {TogglTimer} from "../../../toggl-timer";

@Component({
  selector: 'app-toggl-task',
  templateUrl: './toggl-task.component.html',
  styleUrls: ['./toggl-task.component.css']
})
export class TogglTaskComponent implements OnInit {
  currentTask: TogglTimer;

  constructor(timer: TogglTimer) {
    this.currentTask = timer;
  }

  ngOnInit() {
  }

}
