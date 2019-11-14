import { Allocate } from './allocate';

export interface Employee {
  e_id: number;
  name: string;
  allocates: Allocate[];
}
