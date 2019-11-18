import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { EmployeeService } from 'src/app/services/employee.service';
import { Employee } from 'src/app/models/employee';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[];
  constructor(private employeeService: EmployeeService, private route: Router, private toastrService: ToastrService) { }

  ngOnInit() {
    this.getEmployees();
  }

  getEmployees() {
    this.employeeService.getEmployees().subscribe(
      (res: Employee[]) => this.employees = res
    );
  }

  onDelete(id: string, index: number) {
    this.employeeService.deleteEmployee(id).subscribe(
      () => {
        this.toastrService.error('Employee Deleted', 'Delete', { closeButton: true });
        this.employees.splice(index, 1);
      }
    );
  }

  onEdit(id: number) {
    this.route.navigate(['/employee', 'edit-form', id]);
  }

  onEmployeeAdd(employee: any) {
    this.employees.push(employee);
  }
}
