import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Starship } from '../classes/starship';

@Injectable({
  providedIn: 'root'
})
export class StarshipService {

  constructor(private http: HttpClient) { }

  getStarships(): Observable<Starship[]> {
    return this.http.get<Starship[]>('http://localhost:8080/api/v1/starship/all');
  }
}
