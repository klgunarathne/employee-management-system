import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../models/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private httpClient: HttpClient) { }

  getEmployees(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>('/api/employee');
  }
}
