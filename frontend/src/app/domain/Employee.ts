export class Employee {
  customerId: number;
  data: string;

  constructor(customerId: number, data: any) {
    this.customerId = customerId;
    this.data = String(data);
  }
}
