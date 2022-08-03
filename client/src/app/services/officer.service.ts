import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Officer } from '../classes/officer';

@Injectable({
  providedIn: 'root'
})
export class OfficerService {

  constructor(private http: HttpClient) { }

  getOfficers(): Observable<Officer[]> {
    return this.http.get<Officer[]>('http://localhost:8080/api/v1/officer/all');
  }
}
