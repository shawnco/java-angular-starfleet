import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { StarshipService } from './services/starship.service';
import { StarshipComponent } from './starship/starship.component';
import { StarshipListComponent } from './starship-list/starship-list.component';
import { OfficerService } from './services/officer.service';
import { OfficerComponent } from './officer/officer.component';
import { OfficerListComponent } from './officer-list/officer-list.component';
import { RankService } from './services/rank.service';

@NgModule({
  declarations: [
    AppComponent,
    StarshipComponent,
    StarshipListComponent,
    OfficerComponent,
    OfficerListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [StarshipService, OfficerService, RankService],
  bootstrap: [AppComponent]
})
export class AppModule { }
