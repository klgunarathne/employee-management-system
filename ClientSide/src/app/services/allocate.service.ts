import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Allocate } from '../models/allocate';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AllocateService {

  constructor(private httpClient: HttpClient) { }

  getAllocates(): Observable<Allocate[]> {
    return this.httpClient.get<Allocate[]>('/api/allocate');
  }

  deleteAllocate(id: string) {
    return this.httpClient.delete('/api/allocate/' + id, { responseType: 'text'});
  }

  addAllocate(allocate: Allocate) {
    return this.httpClient.post('/api/allocate', allocate);
  }

  getAllocate(id: string): Observable<Allocate> {
    return this.httpClient.get<Allocate>('/api/allocate/' + id);
  }

  editAllocate(id: string, allocate: Allocate) {
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.httpClient.put('/api/allocate/' + id, allocate, { headers });
  }

  getAllocationFromEmployeeNo(eNo: string) {
    return this.httpClient.get('/api/allocate/employee/' + eNo);
  }
}
