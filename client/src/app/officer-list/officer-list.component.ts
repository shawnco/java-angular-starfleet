import { Component, OnInit } from '@angular/core';
import { Rank } from '../classes/rank';
import { RankService } from '../services/rank.service';
import { Officer } from '../classes/officer';
import { OfficerService } from '../services/officer.service';

@Component({
  selector: 'app-officer-list',
  templateUrl: './officer-list.component.html',
  styleUrls: ['./officer-list.component.css']
})
export class OfficerListComponent {
  ranks!: Rank[];
  officers!: Officer[];

  constructor(
    private service: OfficerService,
    private rankService: RankService
  ) { }

  ngOnInit() {
    this.service.getOfficers().subscribe(officers => {
        console.log(officers);
        this.officers = officers;
    });
    this.ranks = this.rankService.getRanks();
    console.log(this.ranks);
  }

}
