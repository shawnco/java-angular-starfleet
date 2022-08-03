import { Component, OnInit } from '@angular/core';
import { StarshipService } from '../services/starship.service';
import { Starship } from '../classes/starship';

@Component({
  selector: 'app-starship-list',
  templateUrl: './starship-list.component.html',
  styleUrls: ['./starship-list.component.css']
})
export class StarshipListComponent implements OnInit {

  starships!: Starship[];

  constructor(private service: StarshipService) { }

  ngOnInit() {
    this.service.getStarships().subscribe(starships => {
        console.log(starships);
        this.starships = starships;
    })
  }
}
