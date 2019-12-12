import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LayoutComponent} from './container/layout/layout.component';
import { AboutComponent } from './components/about/about.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';


const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: '',
        component: DashboardComponent
      },
      {
        path: 'employee',
        loadChildren: './components/employee/employee.module#EmployeeModule'
      },
      {
        path: 'department',
        loadChildren: './components/department/department.module#DepartmentModule'
      },
      {
        path: 'allocate',
        loadChildren: './components/allocate/allocate.module#AllocateModule'
      },
      {
        path: 'about',
        component: AboutComponent
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
