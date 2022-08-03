import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StarshipListComponent } from './starship-list/starship-list.component';
import { OfficerListComponent } from './officer-list/officer-list.component';

const routes: Routes = [
    { path: 'starships', component: StarshipListComponent },
    { path: 'officers', component: OfficerListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
