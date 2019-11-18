import { Injectable } from '@angular/core';
import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
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
    return this.httpClient.delete('/api/employee/' + id, { responseType: 'text'});
  }

  addEmployee(employee: Employee) {
    return this.httpClient.post('/api/employee', employee);
  }

  getEmployee(id: string): Observable<Employee> {
    return this.httpClient.get<Employee>('/api/employee/' + id);
  }

  editEmployee(id: string, employee: Employee) {
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.httpClient.put('/api/employee/' + id, employee, { headers });
  }
}
