import { Component, OnInit } from '@angular/core';
import { DepartmentService } from 'src/app/services/department.service';
import { Department } from 'src/app/models/department';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.scss']
})
export class DepartmentComponent implements OnInit {

  departments: Department[] = [];
  constructor(private departmentService: DepartmentService, private toastrService: ToastrService) { }

  ngOnInit() {
    this.getDepartments();
  }

  getDepartments() {
    this.departmentService.getDepartments().subscribe(
      (res: Department[]) => this.departments = res
    );
  }

  addDepartment(department: Department) {
    this.departments.push(department);
  }

  onDelete(id: string, index: number) {
    this.departmentService.deleteDepartment(id).subscribe(
      () => {
        this.toastrService.error('Department Deleted', 'Department', { closeButton: true });
        this.departments.splice(index, 1);
      }
    );
  }

}
