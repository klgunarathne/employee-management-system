import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AllocateRoutingModule } from './allocate-routing.module';
import { AllocateComponent } from './allocate.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ChartsModule } from 'ng2-charts';


@NgModule({
  declarations: [AllocateComponent],
  imports: [
    CommonModule,
    AllocateRoutingModule,
    ReactiveFormsModule,
    ChartsModule
  ]
})
export class AllocateModule { }
