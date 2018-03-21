import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AsyncLocalStorageModule } from 'angular-async-local-storage';


import { AppComponent } from './app.component';
import { SettingsComponent } from './settings/settings.component';
import { ConverterComponent } from './converter/converter.component';
import { TogglTaskComponent } from './converter/toggl/toggl-task/toggl-task.component';
import {TogglService} from "./toggl.service";
import {HttpClientModule} from "@angular/common/http";


const appRoutes: Routes = [
  {path: 'converter', component: ConverterComponent},
  {path: 'settings', component:  SettingsComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    SettingsComponent,
    ConverterComponent,
    TogglTaskComponent
  ],
  imports: [
    BrowserModule,
    AsyncLocalStorageModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  exports: [RouterModule],
  providers: [
    HttpClientModule,
    TogglService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
