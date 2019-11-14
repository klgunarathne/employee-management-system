import { Allocate } from './allocate';

export interface Department {
  d_id: number;
  name: string;
  allocates: Allocate[];
}
