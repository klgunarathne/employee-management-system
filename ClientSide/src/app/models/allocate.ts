import { Employee } from './employee';
import { Department } from './department';

export interface Allocate {
  id: number;
  percentage: number;
  duration: number;
  from_date: any;
  to_date: any;

  employee: Employee[];
  department: Department[];
}
