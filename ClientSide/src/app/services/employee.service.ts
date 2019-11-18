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

  deleteEmployee(id: string) {
    return this.httpClient.delete('/api/employee/' + id);
  }

  addEmployee(employee: Employee) {
    return this.httpClient.post('/api/employee', employee);
  }

  getEmployee(id: string): Observable<Employee> {
    return this.httpClient.get<Employee>('/api/employee/' + id);
  }

  editEmployee(id: string, employee: Employee) {
    this.httpClient.put('/api/employee/' + id, employee);
  }
}
