import { Employee } from './employee';
import { Department } from './department';

export interface Allocates {
  id: number;
  percentage: number;
  duration: number;
  from_date: any;
  to_date: any;

  employee: Employee;
  e_no: string;

  department: Department;
  d_no: string;
}
