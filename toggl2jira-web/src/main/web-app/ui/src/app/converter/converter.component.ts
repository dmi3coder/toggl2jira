import {Component, Injectable, OnInit} from '@angular/core';
import {TogglTimer} from "../toggl-timer";
import {element} from "protractor";
import {TogglService} from "../toggl.service";
import {Inject} from "@angular/compiler/src/core";

@Component({
  selector: 'app-converter',
  templateUrl: './converter.component.html',
  styleUrls: ['./converter.component.css']
})
@Injectable()
export class ConverterComponent implements OnInit {
  elements: object[];

  constructor(private service: TogglService) {
    service.getSummary().subscribe(items => {
      this.elements = items;
      console.log("working");
      console.log(items)
    });
  }

  ngOnInit() {
  }

}
