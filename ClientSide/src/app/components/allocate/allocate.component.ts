import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/models/employee';
import { Department } from 'src/app/models/department';
import { DepartmentService } from 'src/app/services/department.service';
import { EmployeeService } from 'src/app/services/employee.service';
import { FormGroup, FormBuilder, Validators, MaxLengthValidator } from '@angular/forms';
import { AllocateService } from 'src/app/services/allocate.service';
import { ToastrService } from 'ngx-toastr';
import { Allocate } from 'src/app/models/allocate';
import { ChartType } from 'chart.js';

@Component({
  selector: 'app-allocate',
  templateUrl: './allocate.component.html',
  styleUrls: ['./allocate.component.scss']
})
export class AllocateComponent implements OnInit {

  employees: Employee[] = [];
  departments: Department[] = [];
  allocateForm: FormGroup;
  allocates: Allocate[] = [];

  // Doughnut
  public doughnutChartLabels: string[] = [];
  public doughnutChartData: number[] = [];
  public doughnutChartType: ChartType = 'doughnut';
  public doughnutColors = [
    {
      backgroundColor: ['rgba(255,0,0,0.3)', 'rgba(0,255,0,0.3)', 'rgba(0,0,255,0.3)'],
    },
  ];

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
      percentage: [0,[ Validators.required, Validators.max(100)]],
      duration: [0],
      from_date: ['', Validators.required],
      to_date: ['', Validators.required],
      employee: this.fb.group({
        e_no: [, Validators.required]
      }),
      department: this.fb.group({
        d_no: [, Validators.required]
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
    this.allocates = [];
    this.allocateService.getAllocationFromEmployeeNo(employee.value).subscribe(
      (res: Allocate[]) => {
        this.allocates = res;
        this.getChartData();
      },
      error => {
        this.toastrService.warning('This employee not allocated to any department', 'Allocate', { closeButton: true });
        this.getChartData();
      }
    );

  }

  getChartData() {
    this.doughnutChartData = [];
    this.doughnutChartLabels = [];
    let totalPrecetage = 0;

    if (this.allocates.length < 1) {
      this.doughnutChartLabels.push('Not Allocated');
      this.doughnutChartData.push(100);
    } else {
      this.allocates.forEach(a => {
        this.doughnutChartLabels.push(a.department.name);
        this.doughnutChartData.push(a.percentage);
        totalPrecetage += a.percentage;
      });

      if (totalPrecetage < 100) {
        this.doughnutChartLabels.push('Not Allocated');
        this.doughnutChartData.push(100 - totalPrecetage);
      }
    }
  }
}
