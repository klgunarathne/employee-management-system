import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { EmployeeService } from 'src/app/services/employee.service';
import { Employee } from 'src/app/models/employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[];
  constructor(private employeeService: EmployeeService, private route: Router) { }

  ngOnInit() {
    this.getEmployees();
  }

  getEmployees() {
    this.employeeService.getEmployees().subscribe(
      (res: Employee[]) => this.employees = res
    );
  }

  onDelete(id: number) {

  }

  onEdit(id: number) {
    this.route.navigate(['/employee', 'edit-form', id]);
  }

  onEmployeeAdd(employee: any) {
    this.employees.push(employee);
  }
}
