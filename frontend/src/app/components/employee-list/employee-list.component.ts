import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { Benefit } from 'src/app/domain/Benefit';
import { Customer } from 'src/app/domain/Customer';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss'],
})
export class EmployeeListComponent implements OnInit {
  employees: any[];
  customer: Customer;
  benefit: Benefit;
  fields: any[];

  employeesFiltered: any[] = [];

  constructor(private http: HttpClient, private modalCtrl: ModalController) {}

  async ngOnInit() {
    await this.getEmployees();
  }

  async getEmployees() {
    const params = new HttpParams().set('customerId', this.customer.id);
    this.http
      .get('http://localhost:8081/employees', { params })
      .subscribe(async (response) => {
        this.employees = response as [];
        await this.getFieldsByBenefit();
      });
  }

  async getFieldsByBenefit() {
    const params = new HttpParams().set('benefitId', this.benefit.id);
    this.http
      .get('http://localhost:8080/benefits/findFieldsNameByBenefit', { params })
      .subscribe(async (response) => {
        this.fields = response as [];
        await this.setEmployeeObject();
      });
  }

  async setEmployeeObject() {
    this.employees.forEach((employee) => {
      const object: any = {};

      this.fields.forEach((field) => {
        if (employee[field.name]) {
          object[field.name] = employee[field.name];
        }
      });

      if (object) {
        this.employeesFiltered.push(object);
      }
    });
  }

  getFieldValue(object: any, key: string) {
    return object[key];
  }

  dismissModal() {
    this.modalCtrl.dismiss();
  }
}
