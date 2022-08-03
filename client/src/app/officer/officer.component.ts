import { Component, OnChanges, Input, SimpleChanges } from '@angular/core';
import { Officer } from '../classes/officer';
import { Rank } from '../classes/rank';

@Component({
  selector: 'app-officer',
  templateUrl: './officer.component.html',
  styleUrls: ['./officer.component.css']
})
export class OfficerComponent implements OnChanges {
  @Input() officer!: Officer;
  @Input() ranks!: Rank[];
  officerRank!: Rank;

  constructor() { }

  ngOnChanges(changes: SimpleChanges): void {
    const find = this.ranks.find(r => r.id == +this.officer.rank);
    if (find) {
      this.officerRank = find;
    }
  }
}
