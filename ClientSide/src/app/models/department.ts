import { Allocate } from './allocate';

export interface Department {
  d_no: number;
  name: string;
  allocates: Allocate[];
}
