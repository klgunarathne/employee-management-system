import { Component, OnInit, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { EmployeeService } from 'src/app/services/employee.service';
import { Employee } from 'src/app/models/employee';
import { EventEmitter } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.scss']
})
export class EmployeeFormComponent implements OnInit {

  employeeForm: FormGroup;
  @Output() newEmployee = new EventEmitter();
  status = ['Active', 'Inactive', 'Probation', 'Retired'];
  id: string;
  isNew = true;
  title: string;
  employee: Employee;
  constructor(
    private fb: FormBuilder,
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private toastrService: ToastrService,
    private router: Router
    ) { }

  ngOnInit() {
    this.initForm();
    this.route.params.subscribe(
      p => {
        if (!this.route.snapshot.params.id) {
          this.isNew = true;
          this.title = 'New Employee';
        } else {
          this.id = p.id;
          this.isNew = false;
          this.title = 'Edit Employee';
          this.getEmployee(this.id);
        }
      }
    );
  }

  initForm() {
    this.employeeForm = this.fb.group({
      e_no: ['', Validators.required],
      name: ['', Validators.required],
      address: [''],
      status: ['Active']
    });
  }

  onSubmit() {
    if (this.isNew) {
      this.employeeService.addEmployee(this.employeeForm.value).subscribe(
        res => {
          this.newEmployee.emit(this.employeeForm.value);
          this.initForm();
          this.toastrService.success('Employee Added', 'Success', { closeButton: true });
        }
      );
    } else {
      this.employeeService.editEmployee(this.id, this.employeeForm.value).subscribe(
        res => {
          this.toastrService.warning('Edit Employee', 'Success', { closeButton: true });
          this.router.navigate(['/employee']);
        }
      );

    }
  }

  getEmployee(id: string) {
    this.employeeService.getEmployee(id).subscribe(
      (res: Employee) => {
        this.employee = res;
        this.employeeForm.patchValue({
          e_no: this.employee.e_no,
          name: this.employee.name,
          address: this.employee.address,
          status: this.employee.status
        });
      }
    );
  }

}
