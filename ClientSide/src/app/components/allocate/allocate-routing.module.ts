import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AllocateComponent } from './allocate.component';


const routes: Routes = [
  {
    path: '',
    component: AllocateComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AllocateRoutingModule { }
