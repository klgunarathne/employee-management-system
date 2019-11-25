import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/models/employee';
import { Department } from 'src/app/models/department';
import { DepartmentService } from 'src/app/services/department.service';
import { EmployeeService } from 'src/app/services/employee.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AllocateService } from 'src/app/services/allocate.service';
import { ToastrService } from 'ngx-toastr';
import { Allocate } from 'src/app/models/allocate';

@Component({
  selector: 'app-allocate',
  templateUrl: './allocate.component.html',
  styleUrls: ['./allocate.component.scss']
})
export class AllocateComponent implements OnInit {

  employees: Employee[] = [];
  departments: Department[] = [];
  allocateForm: FormGroup;
  constructor(
    private departmentService: DepartmentService,
    private employeeService: EmployeeService,
    private allocateService: AllocateService,
    private toastrService: ToastrService,
    private fb: FormBuilder
    ) { }


  ngOnInit() {
    this.getEmployees();
    this.getDepartments();
    this.initForm();
  }

  getDepartments() {
    this.departmentService.getDepartments().subscribe(
      (res: Department[]) => this.departments = res
    );
  }

  getEmployees() {
    this.employeeService.getEmployees().subscribe(
      (res: Employee[]) => this.employees = res
    );
  }

  initForm() {
    this.allocateForm = this.fb.group({
      percentage: [0],
      duration: [0],
      from_date: ['', Validators.required],
      to_date: ['', Validators.required],
      employee: this.fb.group({
        e_no: ['Select Employee', Validators.required]
      }),
      department: this.fb.group({
        d_no:  ['Select Department', Validators.required]
      })
    });
  }

  onSubmit() {
    this.allocateService.addAllocate(this.allocateForm.value).subscribe(
      (res: Allocate) => {
        this.toastrService.success('Employee Allocated to ' + res.employee.name, 'Allocate', { closeButton: true });
        this.allocateForm.reset();
      }
    );
  }

  onEmployeeChange(employee: any) {
    console.log(employee.value);

  }
}
