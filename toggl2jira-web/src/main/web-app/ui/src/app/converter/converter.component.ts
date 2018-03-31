import {Component, Injectable, Input, OnInit} from '@angular/core';
import {TogglTimer} from "../toggl-timer";
import {element} from "protractor";
import {TogglService} from "../toggl.service";
import {Inject} from "@angular/compiler/src/core";
import * as _ from "lodash";
@Component({
  selector: 'app-converter',
  templateUrl: './converter.component.html',
  styleUrls: ['./converter.component.css']
})
@Injectable()
export class ConverterComponent implements OnInit {
  elements: any[];

  constructor(private service: TogglService) {
    service.getSummary().subscribe(items => {
      this.elements = items;
      this.elements.forEach(item => {
        let time = _.sumBy(item.second, el => {return (<any>el).dur});
        item.summary = Math.floor(time/1000/60/60)+' hours '
          +Math.round(time%(1000*60*60)/1000/60)+' minutes' //interval js libraries suck a lot
      });
    });
  }

  ngOnInit() {
  }

}
