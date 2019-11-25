import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AllocateRoutingModule } from './allocate-routing.module';
import { AllocateComponent } from './allocate.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [AllocateComponent],
  imports: [
    CommonModule,
    AllocateRoutingModule,
    ReactiveFormsModule
  ]
})
export class AllocateModule { }
