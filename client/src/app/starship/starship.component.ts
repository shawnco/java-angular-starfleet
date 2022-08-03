import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Starship } from '../classes/starship';
import { StarshipService } from '../services/starship.service';

@Component({
  selector: 'app-starship',
  templateUrl: './starship.component.html',
  styleUrls: ['./starship.component.css']
})
export class StarshipComponent {
  @Input() ship!: Starship;
  @Output() selectedShip = new EventEmitter<Starship>();
  constructor(private service: StarshipService) { }

  click(ship: Starship) {
    this.selectedShip.emit(ship);
  }
}
