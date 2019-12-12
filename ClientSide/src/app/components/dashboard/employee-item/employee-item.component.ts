import { Component, OnInit, Output, Input } from '@angular/core';
import { Employee } from 'src/app/models/employee';
import { AllocateService } from 'src/app/services/allocate.service';
import { ChartType } from 'chart.js';
import { Allocate } from 'src/app/models/allocate';

@Component({
  selector: 'app-employee-item',
  templateUrl: './employee-item.component.html',
  styleUrls: ['./employee-item.component.scss']
})
export class EmployeeItemComponent implements OnInit {

  @Input() employee: Employee;
  public doughnutChartLabels: string[] = [];
  public doughnutChartData: number[] = [];
  public doughnutChartType: ChartType = 'doughnut';
  public doughnutColors = [
    {
      backgroundColor: ['rgba(255,0,0,0.3)', 'rgba(0,255,0,0.3)', 'rgba(0,0,255,0.3)'],
    },
  ];
  allocates: Allocate[] = [];
  constructor(private allocateService: AllocateService) { }

  ngOnInit() {
    this.AllocatedDataFromEmpNo(this.employee.e_no);
  }

  AllocatedDataFromEmpNo(eNo: string) {
    this.allocates = [];
    this.allocateService.getAllocationFromEmployeeNo(eNo).subscribe(
      (res: Allocate[]) => {
        this.allocates = res;
        this.getChartData();
      },
      error => {
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
