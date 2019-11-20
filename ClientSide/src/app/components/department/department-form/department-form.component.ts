import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { DepartmentService } from 'src/app/services/department.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-department-form',
  templateUrl: './department-form.component.html',
  styleUrls: ['./department-form.component.scss']
})
export class DepartmentFormComponent implements OnInit {

  departmentForm: FormGroup;
  @Output() department = new EventEmitter();
  constructor(
    private fb: FormBuilder,
    private departmentService: DepartmentService,
    private toastrService: ToastrService
    ) { }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.departmentForm = this.fb.group({
      d_no: [''],
      name: ['']
    });
  }

  onSubmit() {
    this.departmentService.addDepartment(this.departmentForm.value).subscribe(
      () => {
        this.toastrService.success('Department Added', 'Department', { closeButton: true });
        this.department.emit(this.departmentForm.value);
      }
    );
  }

}
