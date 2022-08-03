import { Injectable } from '@angular/core';
import { Rank } from '../classes/rank';

@Injectable({
  providedIn: 'root'
})
export class RankService {
  constructor() { }

  getRanks(): Rank[] {
    return [
        new Rank(1, 'Ensign'),
        new Rank(2, 'Lieutenant Junior Grade'),
        new Rank(3, 'Lieutenant'),
        new Rank(4, 'Lieutenant Commander'),
        new Rank(5, 'Commander'),
        new Rank(6, 'Captain'),
        new Rank(7, 'Admiral'),
        new Rank(8, 'Fleet Admiral')
    ];
  }
}
