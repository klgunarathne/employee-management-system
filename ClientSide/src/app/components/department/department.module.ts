import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DepartmentRoutingModule } from './department-routing.module';
import { DepartmentComponent } from './department.component';
import { DepartmentFormComponent } from './department-form/department-form.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [DepartmentComponent, DepartmentFormComponent],
  imports: [
    CommonModule,
    DepartmentRoutingModule,
    ReactiveFormsModule
  ]
})
export class DepartmentModule { }
