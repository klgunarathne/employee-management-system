import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Department } from '../models/department';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  constructor(private httpClient: HttpClient) { }

  getDepartments(): Observable<Department[]> {
    return this.httpClient.get<Department[]>('/api/department');
  }

  deleteDepartment(id: string) {
    return this.httpClient.delete('/api/department' + id, { responseType: 'text'});
  }

  addDepartment(department: Department) {
    return this.httpClient.post('/api/department', department);
  }

  getDepartment(id: string): Observable<Department> {
    return this.httpClient.get<Department>('/api/department' + id);
  }

  editDepartment(id: string, department: Department) {
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.httpClient.put('/api/department' + id, department, { headers });
  }
}
